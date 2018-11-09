package com.controller;

import com.pojo.TbClassify;
import com.pojo.TbTopic;
import com.service.TopicService;
import com.tools.utils.JsonUtils;
import com.tools.utils.jedis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
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
     * @return
     */
    @ResponseBody
    @RequestMapping("/getTopicNumAllClassify")
    public Map<Integer, Integer> getTopicNumAllClassify() {
        return topicServiceImpl.selectTopicNumAllClassify();
    }

    /**
     * 根据用户选择，分方法，个数，类别等获取题目信息
     * @param topicNum 生成题目数量
     * @param topicType 题目的生成类型，随机，专项，错题
     * @param classifyId 题目类型，可以传入一个数组，根据多个类型生成题目
     * @return 答题页面
     */
    @RequestMapping("/getTopicToExercise")
    public String getTopicToExercise(double topicNum, String topicType, int[] classifyId) {
        List<TbTopic> list =  topicServiceImpl.getTopicToExercise(topicNum, topicType, classifyId);
        return "";
    }
}
