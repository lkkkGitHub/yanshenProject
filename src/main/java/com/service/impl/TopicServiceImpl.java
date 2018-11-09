package com.service.impl;

import com.dao.TbTopicDao;
import com.pojo.TbClassify;
import com.pojo.TbTopic;
import com.service.ClassifyService;
import com.service.TopicService;
import com.tools.utils.JsonUtils;
import com.tools.utils.jedis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
        // 获取所有的类别,来获取数量
        List<TbClassify> tbClassifyList = classifyServiceImpl.allClassify();
        // 初始化map的大小
        Map<Integer, Integer> map = new HashMap<>(tbClassifyList.size());
        // 根据类别的数量，进行循环并判断缓存中是否存在，不存在即更新缓存
        for (int i = 0; i < tbClassifyList.size(); i++) {
            int x = i + 1;
            Integer integer = JsonUtils.jsonToPojo(jedisClient.hget("classifyNum", String.valueOf(x)), Integer.class);
            if (integer == null) {
                List<TbTopic> tbTopicList = tbTopicDao.selectTopicByClassifyId(x);
                jedisClient.hset("classifyNum", String.valueOf(x), String.valueOf(tbTopicList.size()));
                map.put(x, tbTopicList.size());
            } else {
                map.put(x, integer);
            }
        }
        return map;
    }

    @Override
    public List<TbTopic> getTopicToExercise(double topicNum, String topicType, int[] classifyId, HttpSession session) {
        List<TbTopic> list = new ArrayList<>((int) topicNum);
        //随机生成题目
        if ("".equals(topicType)) {
            for (int i = 0; i < classifyId.length; i++) {
                List<TbTopic> topicList = JsonUtils.jsonToList(
                        jedisClient.hget("topic", String.valueOf(classifyId[i])), TbTopic.class);
                session.getAttribute("UserDidTopicUtil");
            }
        }
        return null;
    }
}
