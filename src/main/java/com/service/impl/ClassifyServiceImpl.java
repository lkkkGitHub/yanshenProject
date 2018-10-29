package com.service.impl;

import com.dao.TbClassifyDao;
import com.pojo.TbClassify;
import com.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lk
 * 2018/10/29 10:37
 * @description:
 */
@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Autowired
    private TbClassifyDao tbClassifyDao;

    @Override
    public List<TbClassify> allClassify() {
        return tbClassifyDao.allClassify();
    }
}
