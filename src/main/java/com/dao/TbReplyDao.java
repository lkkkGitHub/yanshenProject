package com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.pojo.TbReply;


public interface TbReplyDao {
    int insert(@Param("pojo") TbReply pojo);

    int insertSelective(@Param("pojo") TbReply pojo);

    int insertList(@Param("pojos") List<TbReply> pojo);

    int update(@Param("pojo") TbReply pojo);
}
