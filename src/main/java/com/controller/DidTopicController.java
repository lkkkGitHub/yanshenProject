package com.controller;

import com.pojo.TbDidtopic;
import com.pojo.TbTopic;
import com.pojo.TbUser;
import com.service.DidtopicService;
import com.tools.pojoexpansion.UserDidTopicUtil;
import com.tools.utils.JsonUtils;
import com.tools.utils.jedis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lk
 * 2018/11/5 13:28
 * @description:
 */
@Controller
@RequestMapping("/didTopic")
public class DidTopicController {

    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private DidtopicService tbDidtopicServiceImpl;

    /**
     * 获取用户所有类别中所做的题目信息，存入到redis中
     * 包括错题数，正确率，错题题目
     *
     * @param session 获取session中的用户信息
     * @return 返回这个工具类
     */
    @ResponseBody
    @RequestMapping("/getDidTopicUtil")
    public UserDidTopicUtil getDidTopicUtil(HttpSession session) {
        String userName = (String) session.getAttribute("username");
        UserDidTopicUtil userDidTopicUtil =
                JsonUtils.jsonToPojo(jedisClient.hget("UserDidTopicUtil", userName), UserDidTopicUtil.class);
        if (userDidTopicUtil == null) {
            userDidTopicUtil = tbDidtopicServiceImpl
                    .findDidTopicByUserIdAndClassifyId(((TbUser) (session.getAttribute("user"))).getUid());
            jedisClient.hset("UserDidTopicUtil", userName, JsonUtils.objectToJson(userDidTopicUtil));
            return userDidTopicUtil;
        }
        return userDidTopicUtil;
    }

    /**
     * 提交答卷，并清空session中的题目信息
     *
     * @param session 获取缓存中的答题题目信息
     * @return 成功即返回到答案解析页面
     */
    @RequestMapping("/commitAnswer")
    public String commitAnswer(HttpSession session, HttpServletRequest request) {
        String userName = (String) session.getAttribute("username");
        UserDidTopicUtil userDidTopicUtil = JsonUtils.jsonToPojo(jedisClient.hget("UserDidTopicUtil", userName),
                UserDidTopicUtil.class);
        List<TbTopic> topicList = (ArrayList<TbTopic>) session.getAttribute("topicList");
        List<TbDidtopic> didTopicList = tbDidtopicServiceImpl.commitTopic(topicList, (String) session.getAttribute("topicType"),
                ((TbUser) session.getAttribute("user")).getUid(), userDidTopicUtil);
        if (didTopicList != null) {
            if (didTopicList.size() == topicList.size()) {
                jedisClient.hset("UserDidTopicUtil", userName,
                        JsonUtils.objectToJson(userDidTopicUtil));
                session.setAttribute("didTopicList", didTopicList);
                session.removeAttribute("topicList");
                session.removeAttribute("topicType");
                session.removeAttribute("notDoneTopic");
                jedisClient.hdel("notDoneTopic", (String) session.getAttribute("username"));
                jedisClient.hdel("topicType", (String) session.getAttribute("username"));
                return "didTopic";
            }
        }
        request.setAttribute("commitTopicMessage", "提交失败，请联系管理员");
        return "didTopic";
    }

    /**
     * 获取用户点击的下一题信息
     *
     * @param sequenceNext 下一题
     * @param session      获取session中的做完题目信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/getDidTopicToShow")
    public TbDidtopic getDidTopicToShow(HttpSession session, Integer sequenceNext) {
        List<TbDidtopic> didTopicList = (ArrayList<TbDidtopic>) session.getAttribute("didTopicList");
        return didTopicList.get(sequenceNext);
    }

    /**
     * 当用户点击次方法返回home页面时，清除session中的做题信息
     *
     * @return 转发到topic/中的removeNotDoneTopic方法，清除session中的信息
     * 以及清除redis中的信息
     */
    @RequestMapping("/returnHomeAndRemoveSession")
    public String returnHomeAndRemoveSession() {
        return "redirect:/topic/removeNotDoneTopic";
    }

}
