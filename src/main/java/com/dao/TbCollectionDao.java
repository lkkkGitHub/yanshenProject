package com.dao;

import com.pojo.TbCollection;
import com.pojo.TbTopic;
import com.tools.pojoexpansion.Pager;

import java.util.List;


public interface TbCollectionDao {
    /**
     * 插入关注信息，用户点击收藏题目进行收藏
     *
     * @param collection 用户id，题目id
     * @return 影响的行数
     */
    int insert(TbCollection collection);

    /**
     * 更新用户关注信息，取关和关注
     *
     * @param uid        用户id
     * @param topicId    题目id
     * @param deleteFlag 关注信息
     * @return 返回操作是否成功
     */
    int updateCollection(String uid, Integer topicId, Integer deleteFlag);

    /**
     * 查询关注数据的deleteFlag 标签的内容
     *
     * @param uid     用户id
     * @param topicId 题目id
     * @return deleteFlag 内容
     */
    Integer checkCollection(String uid, Integer topicId);

    /**
     * 获取收藏个数
     *
     * @param uid 用户id
     * @return 收藏的个数
     */
    Integer getCollectionNum(String uid);

    /**
     * 获取分页数据
     *
     * @param pager 分页数据开始位置，页面大小
     * @param uid   用户id
     * @return 题目的基本信息
     */
    List<TbTopic> getTopicToPager(String uid, Pager<TbTopic> pager);

    /**
     * 物理删除用户收藏信息
     *
     * @param topicId 题目id
     * @param uid     用户id
     * @return 影响的行数
     */
    Integer delete(Integer topicId, String uid);
}
