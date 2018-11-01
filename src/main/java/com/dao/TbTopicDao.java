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
     * 动态选择sql语句
     * @param tbTopic 封装了题目信息的sql
     * @return 影响的行数
     */
    int insertSelective(TbTopic tbTopic);
}
