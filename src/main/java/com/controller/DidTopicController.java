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
     * 提交答卷
     *
     * @param session 获取缓存中的答题题目信息
     * @return 成功即返回到答案解析页面
     */
    @RequestMapping("/commitAnswer")
    public String commitAnswer(HttpSession session) {
        List<TbTopic> topicList = (ArrayList<TbTopic>) session.getAttribute("topicList");
        List<TbDidtopic> didTopicList = tbDidtopicServiceImpl.commitTopic(topicList,
                ((TbUser) session.getAttribute("user")).getUid());
        if (didTopicList != null) {
            if (didTopicList.size() == topicList.size()) {
                UserDidTopicUtil userDidTopicUtil = tbDidtopicServiceImpl
                        .findDidTopicByUserIdAndClassifyId(((TbUser) (session.getAttribute("user"))).getUid());
                session.setAttribute("UserDidTopicUtil" ,userDidTopicUtil);
                session.setAttribute("didTopicList", didTopicList);
                return "didTopic";
            }
        }
        return null;
    }

}
