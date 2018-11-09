package com.service;

import com.pojo.TbTopic;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author 疯自
 */
public interface TopicService {

    /**
     * 查询所有分类的题目总数量，
     *
     * @return
     */
    Map<Integer, Integer> selectTopicNumAllClassify();

    /**
     * 根据用户选择，分方法，个数，类别等获取题目信息
     *
     * @param topicNum   生成题目数量
     * @param topicType  题目的生成类型，随机，专项，错题
     * @param classifyId 题目类型，可以传入一个数组，根据多个类型生成题目
     * @return
     */
    List<TbTopic> getTopicToExercise(double topicNum, String topicType, int[] classifyId, HttpSession session);
}
