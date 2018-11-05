package com.service;

import com.pojo.TbTopic;

import java.util.List;
import java.util.Map;

/**
 * @author 疯自
 */
public interface TopicService {

    /**
     * 查询所有分类的题目数量，
     *
     * @return
     */
    Map<Integer, Integer> selectTopicNumAllClassify();
}
