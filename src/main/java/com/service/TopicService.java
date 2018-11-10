package com.service;

import com.pojo.TbDidtopic;
import com.pojo.TbTopic;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
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
     * @param classifyIds 题目类型，可以传入一个数组，根据多个类型生成题目
     * @param uid 用户的主键id
     * @param map 用户错题
     * @return
     */
    LinkedList<TbTopic> getTopicToExercise(int topicNum, String topicType,
                                           Map<Integer, List<TbDidtopic>> map, int[] classifyIds, String uid);
}
