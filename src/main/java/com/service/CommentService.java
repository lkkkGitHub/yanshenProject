package com.service;

import com.pojo.TbComment;

import java.util.List;

/**
 * @author lk
 * 2018/12/11 22:04
 */
public interface CommentService {

    /**
     * 查询评论的内容
     *
     * @param topicId 题目id
     * @return 评论以及评论的用户信息
     */
    List<TbComment> findCommentByTopicId(Integer topicId);

    /**
     * 插入评论信息
     *
     * @param tbComment 评论内容，用户id，题目id
     * @return
     */
    boolean insertComment(TbComment tbComment);

    /**
     * 根据评论id，删除评论信息以及评论下的回复信息
     *
     * @param commentId
     * @return
     */
    boolean deleteById(Integer commentId);
}
