package com.service.impl;

import com.dao.TbDidtopicDao;
import com.pojo.TbDidtopic;
import com.service.DidtopicService;
import com.tools.pojoexpansion.UserDidTopicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lk
 * 2018/11/5 11:45
 * @description:
 */
@Service
public class DidtopicServiceImpl implements DidtopicService {

    @Autowired
    private TbDidtopicDao didtopicDao;

    @Override
    public UserDidTopicUtil findDidTopicByUserId(String userId) {
        List<TbDidtopic> list = didtopicDao.findDidTopicByUserId(userId);
        UserDidTopicUtil userDidTopicUtil = new UserDidTopicUtil();
        userDidTopicUtil.setDidTopicNum(list.size());
        Integer errorCount = 0;
        for (TbDidtopic tbDidtopic: list) {
            if (tbDidtopic.getError() == 0) {
                errorCount++;
            }
        }
        userDidTopicUtil.setErrorDidTopicNum(errorCount);
        return userDidTopicUtil;
    }
}
