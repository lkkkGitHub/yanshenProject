package com.controller;


import com.pojo.TbCity;
import com.pojo.TbProvince;
import com.pojo.TbUser;
import com.service.UserService;
import com.tools.finaltools.DidTopicFinalTool;
import com.tools.finaltools.UserFinalTool;
import com.tools.utils.Base64;
import com.tools.utils.MD5Utils;
import com.tools.utils.SendEmail;
import com.tools.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * @author lk 2018/9/7 11:23
 * @description:
 */

@Controller
@RequestMapping("/User")
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * 将客户端空白输入传入""转为null
     *
     * @param binder 不知道
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    /**
     * 更新用户信息
     *
     * @param user 封装了用户的性别，vip，邮箱地址，电话，用户名,地址
     * @return 重定向到个人显示信息界面
     */
    @RequestMapping(value = "/changUserInfo", method = {RequestMethod.POST})
    public String changeUserInfo(TbUser user, HttpServletRequest request, HttpSession session) {
        userService.changeUserInfo(user);
        String uid = ((TbUser) request.getSession().getAttribute(UserFinalTool.USER)).getUid();
        // 用户简单个人信息
        TbUser userInfo = userService.selectUserInfo(uid);
        session.setAttribute(UserFinalTool.USER_NAME, userInfo.getUname());
        session.setAttribute(UserFinalTool.USER_IMG, userInfo.getImage());
        session.setAttribute(UserFinalTool.USER, userInfo);
        return "personal";
    }

    /**
     * 以比特流上传图片文件，并获取sessino中“username” 的用户名， 将该用户的图片的地址，写入到数据库
     *
     * @param imgDate 比特类型图片数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/upHeadImage")
    public Boolean upHeadImage(String imgDate, HttpSession session) {
        TbUser user = (TbUser) session.getAttribute(UserFinalTool.USER);
        String str = imgDate.substring(imgDate.indexOf(",") + 1);
        byte[] bs = Base64.GenerateImage(str);
        if (bs == null) {
            return false;
        }
        String uploadPath = "/static/img/userHeadImg";
        String realUploadPath = session.getServletContext().getRealPath(uploadPath);
        String userImg = "/" + user.getUid() + ".jpg";
        File file = new File(realUploadPath + userImg);
        FileImageOutputStream imageOutput = null;
        try {
            imageOutput = new FileImageOutputStream(file);
            imageOutput.write(bs, 0, bs.length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                imageOutput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        user.setImage(uploadPath + userImg);
        // 将图片存入数据库
        int flag = userService.upHeadImage(user);
        // 更新session中的图片的数据
        if (flag == 1) {
            session.setAttribute(UserFinalTool.USER_IMG, uploadPath + userImg);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据用户地址id 查询用户地址信息,
     *
     * @param addressId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userCityInfo")
    public TbCity userCityInfo(String addressId) {
        return userService.selectUserCity(addressId);
    }

    /**
     * 查询所有省信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/allProvinceInfo")
    public List<TbProvince> allProvinceInfo() {
        return userService.selectProvince();
    }

    /**
     * 城市信息
     *
     * @param pid 省id
     * @return
     */
    @ResponseBody
    @RequestMapping("/CityInfoById")
    public List<TbCity> findCityInfo(Integer pid) {
        return userService.selectCityByPid(pid);
    }

    /**
     * 注销登陆
     *
     * @param session
     * @return
     */
    @RequestMapping("/exit")
    public String exitUser(HttpSession session) {
        session.removeAttribute(UserFinalTool.USER_NAME);
        session.removeAttribute(UserFinalTool.USER_IMG);
        session.removeAttribute(UserFinalTool.USER);
        session.removeAttribute(DidTopicFinalTool.USER_DIDTOPIC_UTIL);
        return "index";
    }

    /**
     * 点击头像显示用户的个人信息，传入用户的uid 查询用户个人信息，根据传入的id查询用户个人信息
     *
     * @param request 传入用户信息
     * @return 返回到userInfo 页面 只显示用户的信息
     */
    @RequestMapping("/personalInfo")
    public String personalInfo(HttpServletRequest request, String uid) {
        // 用户简单个人信息
        TbUser user = userService.selectUserInfo(uid);
        request.setAttribute("userInfo", user);
        return "userInfo";
    }

    /**
     * 登陆，检查账号密码时候正确，并将 用户名 以及 图片的url 用户所有信息 存入session中
     * 分别命名为 “usrename” “imgstr” “user”
     * 同时判断用户是否含有未作完的题目，断点续做
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login")
    public Boolean login(String userName, String passWord, HttpSession session) {
        TbUser user = userService.login(userName, passWord);
        if (user != null) {
            if (user.getStatus()) {
                session.setAttribute(UserFinalTool.USER_NAME, user.getUname());
                session.setAttribute(UserFinalTool.USER_IMG, user.getImage());
                session.setAttribute(UserFinalTool.USER, user);
                session.setAttribute(UserFinalTool.UID, user.getUid());
                return true;
            } else {
                return null;
            }
        } else {
            return false;
        }
    }

    /**
     * 注册写入数据库 uid, uname, password, email, phone, sex(0男，1女，2保密）,
     * image,status(0false:删除 ，1true存在), VIP（0 非，1是）
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/regist", method = {RequestMethod.POST})
    public Boolean regist(TbUser user) {
        user.setUid(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        user.setPassword(MD5Utils.md5(user.getPassword()));
        return userService.regist(user);
    }

    /**
     * 修改密码
     *
     * @param userName
     * @param passWord
     * @return
     */
    @ResponseBody
    @RequestMapping("/changePassword")
    public Boolean changePassword(String userName, String passWord) {
        return userService.changePassword(userName, MD5Utils.md5(passWord));
    }

    /**
     * 效验用户名是否为唯一
     *
     * @param uname
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/verifyUname")
    public Boolean verifyUname(String uname) {
        return userService.selectByName(uname);
    }

    /**
     * 效验邮箱是否唯一
     *
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/verifyEmail")
    public Boolean verifyEmail(String email) {
        return userService.selectByEmail(email);
    }

    /**
     * 效验电话是否唯一
     *
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/verifyPhone")
    public Boolean verifyPhone(String phone) {
        return userService.selectByPhone(phone);
    }

    /**
     * 验证用户的邮箱地址是否正确
     *
     * @param uname 用户名
     * @param email 邮箱地址
     * @return
     */
    @ResponseBody
    @RequestMapping("/verifyUnameAndEmail")
    public Boolean verifyUnameAndEmail(String uname, String email) {
        return userService.selectByUnameAndEmail(uname, email);
    }

    /**
     * 发送验证码邮件,将验证码存储到session中 同时记录下验证码的超时时间，计算验证码超时
     *
     * @param email 收件箱地址
     * @return 确认是否发送成功
     */
    @ResponseBody
    @RequestMapping(value = "/sendEmail")
    public Boolean sendEmail(String email, String sendFlag, HttpSession session, HttpServletRequest request) {
        boolean flag = false;
        String code = null;
        Date codeOverTime = (Date) request.getSession().getAttribute(UserFinalTool.CODE_OVER_TIME);
        if (codeOverTime != null) {
            if (TimeUtils.compareTime(codeOverTime, TimeUtils.getNowTime())) {
                flag = this.sendCode(email, sendFlag, session);
            } else {
                // 此判断供测试及演示使用，打印出每次的code；
                code = (String) session.getAttribute(UserFinalTool.CODE);
            }
        } else {
            flag = this.sendCode(email, sendFlag, session);
        }
        return flag;
    }

    /**
     * 发送验证码，并且存储到session中
     *
     * @param email    收邮件的地址
     * @param sendFlag 发送验证码的种类
     * @param session  session存储验证码
     * @return 是否发送成功
     */
    private boolean sendCode(String email, String sendFlag, HttpSession session) {
        boolean flag = false;
        String code = SendEmail.sendEamilCode(email, sendFlag);
        if (code != null) {
            session.setAttribute(UserFinalTool.CODE, code);
            session.setAttribute(UserFinalTool.CODE_OVER_TIME, TimeUtils.addMinuteTime(3));
            flag = true;
        }
        System.out.println(code);
        return flag;
    }

    /**
     * 从sessino中获取验证码，效验邮件验证码是否正确, 同时取得验证码超时的时间 判断验证码是否超时 每次效验成功即销毁验证码对象
     * 有两个bug 解决不了     效验验证码会效验两次，所以清除session中的信息会出现验证失败的问题
     *
     * @param verifyNo 用户输入验证码
     * @return 确认是否正确
     */
    @ResponseBody
    @RequestMapping(value = "/verifyCode")
    public Boolean verifyCode(String verifyNo, HttpServletRequest request) {
        boolean flag = false;
        HttpSession session = request.getSession();
        Date codeOverTime = (Date) session.getAttribute(UserFinalTool.CODE_OVER_TIME);
        if (codeOverTime != null) {
            if (TimeUtils.compareTime(codeOverTime, TimeUtils.getNowTime())) {
                session.removeAttribute(UserFinalTool.CODE);
                session.removeAttribute(UserFinalTool.CODE_OVER_TIME);
                return flag;
            }
        }
        String code = (String) session.getAttribute(UserFinalTool.CODE);
        if (code.equals(verifyNo.trim())) {
            flag = true;
        }
        return flag;
    }

}