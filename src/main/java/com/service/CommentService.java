package com.service;

import com.pojo.TbComment;

/**
 * @author lk
 * 2018/12/11 22:04
 */
public interface CommentService {

    /**
     * 根据题目id，查询评论信息，并且查询评论的用户信息
     *
     * @param topicId
     * @return
     */
    TbComment findCommentByTopicId(Integer topicId);
}
