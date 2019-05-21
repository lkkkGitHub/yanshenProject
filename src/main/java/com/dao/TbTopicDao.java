package com.dao;

import com.pojo.TbTopic;

import java.util.List;

/**
 * @author 疯自
 */
public interface TbTopicDao {
    /**
     * 动态选择插入sql语句
     *
     * @param tbTopic 封装了题目信息的sql
     * @return 影响的行数
     */
    int insertSelective(TbTopic tbTopic);

    /**
     * 根据分类，查询题目信息，以及连接查询题目的选项信息
     *
     * @param classifyId 分类id
     * @return
     */
    List<TbTopic> selectTopicByClassifyId(Integer classifyId);

    /**
     * 获取用户再改分类下没有做过的题目
     *
     * @param uid        用户id
     * @param classifyId 分类id
     * @param topicNum   一次查询的题目数量
     * @return 返回未做过的题目
     */
    List<TbTopic> selectUserNoDidTopicByUidAndClassifyId(String uid, Integer classifyId, Integer topicNum);

    /**
     * 根据题目id 查询题目信息
     *
     * @param topicId 题目id
     * @return 题目信息
     */
    TbTopic selectTopicByTopicId(Integer topicId);

    /**
     * 获取用户做对的题目信息，以及做错的题目信息
     *
     * @param userId     用户id
     * @param error      正确与否 0 1
     * @param classifyId 类别的id分类获取
     * @param i          题目生成数量
     * @return 题目信息以及选项
     */
    List<TbTopic> selectErrorTopic(String userId, Integer error, Integer classifyId, Integer i);

    /**
     * 根据题目id查询题目信息
     *
     * @param topicId
     * @return
     */
    TbTopic selectTopicByTopicIds(Integer topicId);
}
