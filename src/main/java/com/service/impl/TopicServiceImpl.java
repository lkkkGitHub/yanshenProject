package com.service.impl;

import com.dao.TbTopicDao;
import com.pojo.TbTopic;
import com.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.Topic;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lk
 * 2018/10/31 21:59
 * @description:
 */
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TbTopicDao tbTopicDao;

    @Override
    public Map<Integer, Integer> selectTopicNumAllClassify() {
        Map<Integer, Integer> map = new HashMap<>(6);
        for (int i = 0; i < 6; i++) {
            List<TbTopic> list = tbTopicDao.selectTopicByClassifyId(i + 1);
            map.put(i + 1, list.size());
        }
        return map;
    }
}
