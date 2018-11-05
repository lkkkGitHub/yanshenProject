package com.dao;

import com.pojo.TbOption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.pojo.TbTopic;

/**
 * @author 疯自
 */
public interface TbTopicDao {
    /**
     * 动态选择插入sql语句
     * @param tbTopic 封装了题目信息的sql
     * @return 影响的行数
     */
    int insertSelective(TbTopic tbTopic);

    /**
     * 根据分类，查询题目信息，以及连接查询题目的选项信息
     * @param classifyId 分类id
     * @return
     */
    List<TbTopic> selectTopicByClassifyId(Integer classifyId);
}
