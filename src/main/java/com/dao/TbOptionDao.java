package com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.pojo.TbOption;

/**
 * @author 疯自
 */
public interface TbOptionDao {
    /**
     * 动态sql插入数据
     * @param tbOption
     * @return
     */
    int insertSelective(TbOption tbOption);

}
