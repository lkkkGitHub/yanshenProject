package com.service;

import com.pojo.TbReply;

import java.util.List;

/**
 * @author lk
 * 2018/12/9 20:36
 */
public interface ReplyService {

    /**
     * 根据评论的id，查询评论的回复信息，以及回复的用户信息
     *
     * @param commentId 评论id
     * @return
     */
    List<TbReply> findReplyByCommentId(Integer commentId);

    /**
     * 根据评论id，查询评论的回复数量
     *
     * @param commentId
     * @return
     */
    Integer findReplyCountByCommentId(Integer commentId);
}
