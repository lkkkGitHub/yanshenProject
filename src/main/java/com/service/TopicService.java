package com.service;

import com.pojo.TbTopic;

import java.util.LinkedList;
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
     * @param topicNum    生成题目数量
     * @param topicType   题目的生成类型，随机，专项，错题
     * @param classifyIds 题目类型，可以传入一个数组，根据多个类型生成题目
     * @param uid         用户的主键id
     * @return
     */
    LinkedList<TbTopic> getTopicToExercise(int topicNum, String topicType, int[] classifyIds, String uid);

    /**
     * 根据题目id查询题目信息
     *
     * @param topicId 题目id
     * @return 题目信息
     */
    TbTopic getTopic(Integer topicId);
}
