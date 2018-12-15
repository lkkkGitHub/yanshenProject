package com.dao;

import com.pojo.TbReply;

import java.util.List;

/**
 * @author 疯自
 */
public interface TbReplyDao {
    /**
     * 根据评论信息，查询评论的回复信息以及回复的用户
     *
     * @param commentId 评论id
     * @return
     */
    List<TbReply> findReplyByCommentId(Integer commentId);

    /**
     * 根据评论信息查询评论的回复个数
     *
     * @param commentId 评论id
     * @return
     */
    Integer findReplyCountByCommentId(Integer commentId);

    /**
     * 插入回复的信息
     *
     * @param tbReply 回复内容，父id，评论id，用户id，创建时间
     * @return 影响的行数
     */
    Integer insertSelective(TbReply tbReply);
}
