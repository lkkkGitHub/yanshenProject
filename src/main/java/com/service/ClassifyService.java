package com.service;

import com.pojo.TbClassify;

import java.util.List;

/**
 * @author 疯自
 */
public interface ClassifyService {

    /**
     * 显示所有类别信息
     * 并加入redis进行缓存管理
     * @return 所有的类别信息，以及id
     */
    List<TbClassify> allClassify();
}
