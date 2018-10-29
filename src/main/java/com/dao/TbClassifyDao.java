package com.dao;

import com.pojo.TbClassify;

import java.util.List;

/**
 * @author 疯自
 */
public interface TbClassifyDao {

    /**
     * 获取全部的分类信息，名称，以及id
     * @return
     */
    List<TbClassify> allClassify();
}
