package com.service.impl;

import com.dao.TbTopicDao;
import com.pojo.TbClassify;
import com.pojo.TbTopic;
import com.service.ClassifyService;
import com.service.TopicService;
import com.tools.utils.JsonUtils;
import com.tools.utils.jedis.JedisClient;
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

    @Autowired
    private ClassifyService classifyServiceImpl;

    @Autowired
    private JedisClient jedisClient;

    @Override
    public Map<Integer, Integer> selectTopicNumAllClassify() {
        // 获取所有的类别数量
        List<TbClassify> tbClassifyList = classifyServiceImpl.allClassify();
        // 初始化map的大小
        Map<Integer, Integer> map = new HashMap<>(tbClassifyList.size());
        // 根据类别的数量，进行循环并判断缓存中是否存在，不存在即更新缓存
        for (int i = 0; i < tbClassifyList.size(); i++) {
            int x = i + 1;
            Integer integer = JsonUtils.jsonToPojo(jedisClient.hget("classifyNum",String.valueOf(x)), Integer.class);
            if (integer == null) {
                List<TbTopic> tbTopicList  = tbTopicDao.selectTopicByClassifyId(x);
                jedisClient.hset("classifyNum", String.valueOf(x), String.valueOf(tbTopicList.size()));
                map.put(x, tbTopicList.size());
            } else {
                map.put(x, integer);
            }
        }
        return map;
    }
}
