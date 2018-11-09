package com.controller;

import com.pojo.TbUser;
import com.service.DidtopicService;
import com.tools.pojoexpansion.UserDidTopicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
}
