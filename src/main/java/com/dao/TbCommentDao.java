package com.dao;

import com.pojo.TbComment;

import java.util.List;

/**
 * @author 疯自
 */
public interface TbCommentDao {
    /**
     * 根据题目id，查询题目评论，以及评论的用户信息
     *
     * @param topicId 题目id
     * @return 评论信息以及评论的用户信息
     */
    List<TbComment> findCommentByTopicId(Integer topicId);

    /**
     * 根据题目id，查询评论的数量
     *
     * @param topicId 题目id
     * @return 评论的数量
     */
    Integer findCommentCountByTopicId(Integer topicId);
}
