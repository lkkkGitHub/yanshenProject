package com.controller;

import com.pojo.TbTopic;
import com.pojo.TbUser;
import com.service.TopicService;
import com.tools.pojoexpansion.UserDidTopicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author lk
 * 2018/11/5 14:56
 * @description:
 */
@Controller
@RequestMapping("/topic")
public class TopicController {

    /**
     *
     */
    @Autowired
    private TopicService topicServiceImpl;


    /**
     * 查询所有类别的题目总数
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/getTopicNumAllClassify")
    public Map<Integer, Integer> getTopicNumAllClassify() {
        return topicServiceImpl.selectTopicNumAllClassify();
    }

    /**
     * 根据用户选择，分方法，个数，类别等获取题目信息
     *
     * @param topicNum    生成题目数量
     * @param topicType   题目的生成类型，随机，专项，错题
     * @param classifyIds 题目类型，可以传入一个数组，根据多个类型生成题目
     * @param session     获取用户信息
     * @return 答题页面
     */
    @RequestMapping("/getTopicToExercise")
    public String getTopicToExercise(int topicNum, String topicType, int[] classifyIds, HttpSession session) {
        TbUser user = (TbUser) session.getAttribute("user");
        UserDidTopicUtil userDidTopicUtil = (UserDidTopicUtil) session.getAttribute("UserDidTopicUtil");
        LinkedList<TbTopic> list = topicServiceImpl.getTopicToExercise(topicNum, topicType,
                userDidTopicUtil.getMap() ,classifyIds, user.getUid());

        return "";
    }
}
