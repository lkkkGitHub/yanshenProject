package com.controller;

import com.pojo.TbDidtopic;
import com.pojo.TbTopic;
import com.pojo.TbUser;
import com.service.DidtopicService;
import com.tools.pojoexpansion.UserDidTopicUtil;
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
    private DidtopicService tbDidtopicServiceImpl;

    /**
     * 获取用户所有类别中所做的题目信息，存入session
     * 包括错题数，正确率，错题题目
     *
     * @param session 将信息存入到session中，
     * @return 返回这个工具类
     */
    @ResponseBody
    @RequestMapping("/getDidTopicUtil")
    public UserDidTopicUtil getDidTopicUtil(HttpSession session) {
        UserDidTopicUtil userDidTopicUtil = null;
        if (session.getAttribute("UserDidTopicUtil") == null) {
            userDidTopicUtil = tbDidtopicServiceImpl
                    .findDidTopicByUserIdAndClassifyId(((TbUser) (session.getAttribute("user"))).getUid());
            session.setAttribute("UserDidTopicUtil", userDidTopicUtil);
        } else {
            userDidTopicUtil = (UserDidTopicUtil) (session.getAttribute("UserDidTopicUtil"));
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
        List<TbTopic> topicList = (ArrayList<TbTopic>) session.getAttribute("topicList");
        List<TbDidtopic> didTopicList = tbDidtopicServiceImpl.commitTopic(topicList,
                ((TbUser) session.getAttribute("user")).getUid());
        if (didTopicList != null) {
            if (didTopicList.size() == topicList.size()) {
                UserDidTopicUtil userDidTopicUtil = tbDidtopicServiceImpl
                        .findDidTopicByUserIdAndClassifyId(((TbUser) (session.getAttribute("user"))).getUid());
                session.setAttribute("UserDidTopicUtil" ,userDidTopicUtil);
                session.setAttribute("didTopicList", didTopicList);
                session.removeAttribute("topicList");
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
     * @param session 获取session中的做完题目信息
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
     * @param session
     * @return
     */
    @RequestMapping("/returnHomeAndRemoveSession")
    public String returnHomeAndRemoveSession(HttpSession session) {
        session.removeAttribute("didTopicList");
        return "redirect:/home";
    }
}
