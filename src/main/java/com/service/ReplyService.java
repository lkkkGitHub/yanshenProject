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

    /**
     * 插入评论信息，初始化时间，为当前时间
     *
     * @param tbReply 用户id，父if，评论id，回复内容
     * @return
     */
    boolean insertReply(TbReply tbReply);

    /**
     * 根据id，删除回复的信息；当id数组为1时，调用直接删除，不为1时，使用in删除
     *
     * @param replyIds 回复id s
     * @return
     */
    boolean deleteReplyById(Integer[] replyIds);
}
