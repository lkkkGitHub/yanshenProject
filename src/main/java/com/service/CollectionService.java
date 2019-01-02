package com.service;

import com.pojo.TbDidtopic;
import com.pojo.TbTopic;
import com.tools.pojoexpansion.Pager;

import java.util.List;

/**
 * @author lk
 * 2018/11/30 15:24
 */
public interface CollectionService {
    /**
     * 插入收藏信息，用户收藏该题目
     *
     * @param uid     用户id
     * @param topicId 题目id
     * @return 插入成功即返回true，失败返回false
     */
    boolean insertCollection(String uid, Integer topicId);

    /**
     * 插入过信息之后，用户收藏和取消题目
     *
     * @param uid        用户id
     * @param topicId    题目id
     * @param deleteFlag 是否关注 0关注，1表示取关
     * @return 返回操作结果
     */
    boolean deleteCollection(String uid, Integer topicId, Integer deleteFlag);

    /**
     * 查看用户之前是否关注了该题目，以及目前是否关注了该题目
     *
     * @param uid     用户id
     * @param topicId 题目id
     * @return 之前已经关注，返回deleteFlag 0表示关注 1表示取关 ；没有关注返回null
     */
    Integer checkCollection(String uid, Integer topicId);

    /**
     * 根据用户id 获取用户收藏信息的个数
     *
     * @param uid 用户id
     * @return 收藏信息个数
     */
    Integer getCollectionNum(String uid);

    /**
     * 根据用户id 获取用户收藏的所有题目信息
     *
     * @param uid   用户id
     * @param pager 分页类，再sql后加上限制
     * @return 用户所有题目信息
     */
    List<TbTopic> getCollectionTopic(String uid, Pager<TbTopic> pager);

    /**
     * 根据用户id，题目id，删除用户的收藏信息
     *
     * @param topicId 题目id
     * @param uid     用户id
     * @return 删除成功 true
     */
    Boolean delete(Integer topicId, String uid);

    /**
     * 根据用户id 题目id 查询用户收藏的题目具体信息
     *
     * @param uid     用户id
     * @param topicId 题目id
     * @return
     */
    TbDidtopic getDidTopic(String uid, Integer topicId);
}
