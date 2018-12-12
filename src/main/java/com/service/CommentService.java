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
}
