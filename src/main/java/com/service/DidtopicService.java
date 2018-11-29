package com.service;

import com.pojo.TbDidtopic;
import com.pojo.TbTopic;
import com.tools.pojoexpansion.UserDidTopicUtil;

import java.util.List;

/**
 * @author 疯自
 */
public interface DidtopicService {

    /**
     * 查询用户所有做过的题目
     * @param userId
     * @return
     */
    UserDidTopicUtil findDidTopicByUserIdAndClassifyId(String userId);


    /**
     * 提交答卷，错误的题目将error标记设置为 0， 1表示正确，并且添加上错误的选项
     * 并动态的维护用户做题情况
     *
     * @param list 所有的题目信息
     * @param uid 用户id信息
     * @param topicType 题目类型
     * @param userDidTopicUtil 用户的个人做题情况
     * @return 影响的行数，用于controller判断是否成功插入
     */
    List<TbDidtopic> commitTopic(List<TbTopic> list, String topicType, String uid, UserDidTopicUtil userDidTopicUtil);

    /**
     * 用户收藏题目，以及取消收藏
     *
     * @param collection 收藏信息
     * @param uid 用户id
     * @param topicId 题目信息
     * @return 成功及返回true
     */
    boolean updateDidTopicCollection(Integer collection, String uid, Integer topicId);

    /**
     * 检查是否收藏了该题目
     *
     * @param uid 用户id
     * @param topicId 题目id
     * @return 收藏了返回true 失败返回false
     */
    boolean checkCollection(String uid, Integer topicId);
}
