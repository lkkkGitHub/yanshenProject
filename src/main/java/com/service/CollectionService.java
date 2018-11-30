package com.service;

import org.springframework.stereotype.Service;

/**
 * @author lk
 * 2018/11/30 15:24
 */
@Service
public interface CollectionService {
    /**
     * 插入收藏信息，用户收藏该题目
     *
     * @param uid 用户id
     * @param topicId 题目id
     * @return 插入成功即返回true，失败返回false
     */
    boolean insertCollection(String uid, Integer topicId);

    /**
     * 插入过信息之后，用户收藏和取消题目
     *
     * @param uid 用户id
     * @param topicId 题目id
     * @param deleteFlag 是否关注 0关注，1表示取关
     * @return 返回操作结果
     */
    boolean deleteCollection(String uid, Integer topicId, Integer deleteFlag);

    /**
     * 查看用户之前是否关注了该题目，以及目前是否关注了该题目
     * @param uid 用户id
     * @param topicId 题目id
     * @return 之前已经关注，返回deleteFlag 0表示关注 1表示取关 ；没有关注返回null
     */
    Integer checkCollection(String uid, Integer topicId);
}
