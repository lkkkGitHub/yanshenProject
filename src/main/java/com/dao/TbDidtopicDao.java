package com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.pojo.TbDidtopic;

/**
 * @author 疯自
 * 做过的题目关联表
 */
public interface TbDidtopicDao {

    /**
     * 根据用户id，查询用户做过的题目信息
     * @param userId 用户id
     * @param classifyId 题目分类id
     * @return 返回所有用户的做过题目信息
     */
    List<TbDidtopic> findDidTopicByUserIdAndClassifyId(String userId, Integer classifyId);

    /**
     * 插入用户的做题信息
     * @param tbDidtopicList 做题的具体信息
     * @return 影响的行数
     */
    int insertList(List<TbDidtopic> tbDidtopicList);
}
