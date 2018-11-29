package com.dao;

import com.pojo.TbDidtopic;

import java.util.List;

/**
 * @author 疯自
 * 做过的题目关联表
 */
public interface TbDidtopicDao {

    /**
     * 根据用户id，查询用户做过的题目信息
     *
     * @param userId     用户id
     * @param classifyId 题目分类id
     * @return 返回所有用户的做过题目信息
     */
    List<TbDidtopic> findDidTopicByUserIdAndClassifyId(String userId, Integer classifyId);

    /**
     * 插入用户的做题信息
     *
     * @param tbDidtopicList 做题的具体信息
     * @return 影响的行数
     */
    int insertList(List<TbDidtopic> tbDidtopicList);

    /**
     * 更新用户所作的错题信息;
     *
     * @param tbDidtopicList 做题信息
     * @return 影响的行数
     */
    int updateDidTopic(List<TbDidtopic> tbDidtopicList);

    /**
     * 根据用户id，以及题目id 更新已做题目的收藏字段
     *
     * @param collection 关注
     * @param userId     用户id
     * @param topicId    题目id
     * @return 影响的行数
     */
    int updateDidTopicCollection(Integer collection, String userId, Integer topicId);

    /**
     * 查询用户是否收藏了该歌曲
     *
     * @param userId  用户id
     * @param topicId 题目id
     * @return 收藏了返回1 没有收藏返回 0
     */
    int checkCollection(String userId, Integer topicId);
}
