package com.dao;

import com.pojo.TbCollection;


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
}
