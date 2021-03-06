package com.dao;

import com.pojo.TbReply;
import com.tools.pojoexpansion.Pager;

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

    /**
     * 根据单个id删除回复信息
     *
     * @param replyId
     * @return
     */
    Integer deleteById(Integer replyId);

    /**
     * 根据id，删除多个回复
     *
     * @param replyIdList
     * @return
     */
    Integer deleteByIds(List<Integer> replyIdList);

    /**
     * 根据id，父id，
     *
     * @param replyId
     * @return
     */
    List<Integer> findReplyFatherId(Integer replyId);

    /**
     * 根据父id 查询评论信息
     *
     * @param fatherId
     * @return
     */
    List<TbReply> findReplyByFatherId(Integer fatherId);

    /**
     * 根据是否已读获取用户的回复数量
     *
     * @param toUid
     * @param isRead
     * @return
     */
    Integer getReplyCountByIsRead(String toUid, Integer isRead);

    /**
     * 根据是否已读获取用户的回复信息
     *
     * @param toUid
     * @param isRead
     * @param pager
     * @return
     */
    List<TbReply> getReplyByIsRead(String toUid, Integer isRead, Pager<TbReply> pager);

    /**
     * 更新阅读状态
     *
     * @param replyId
     * @return
     */
    Integer updateIsRead(Integer replyId);
}
