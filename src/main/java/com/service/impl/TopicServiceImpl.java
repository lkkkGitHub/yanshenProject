package com.service.impl;

import com.dao.TbTopicDao;
import com.pojo.TbClassify;
import com.pojo.TbDidtopic;
import com.pojo.TbTopic;
import com.service.ClassifyService;
import com.service.TopicService;
import com.tools.utils.JsonUtils;
import com.tools.utils.jedis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    /**
     * 移除多于的题目，如果题目数量过大
     *
     * @param list     生成的最后的题目集合
     * @param topicNum 题目总数需要的
     * @param length 类别的个数
     * @return 处理好的LinkedList集合
     */
    private void ifBigRemove(LinkedList<TbTopic> list, int topicNum, int length) {
        if (list.size() > topicNum) {
            int index = topicNum / length + 1;
            for (int i = list.size() - topicNum; i > 0; i--) {
                list.remove(index * (i + 1) - 1);
            }
        }
    }

    /**
     * 判断集合中题目的数量以及需求题目数量的大小
     *
     * @param size     集合数量
     * @param topicNum 需求题目总数量
     * @return
     */
    private int judgeTopicSize(int size, int classifyIdsLength, int topicNum) {
        int i = topicNum / classifyIdsLength;
        if (topicNum % classifyIdsLength == 0) {
            if (size > i) {
                return i;
            } else {
                return size;
            }
        } else {
            if (size > ++i) {
                return i;
            } else {
                return size;
            }
        }
    }

    @Override
    public LinkedList<TbTopic> getTopicToExercise(int topicNum, String topicType,
                                                  Map<Integer, List<TbDidtopic>> map, int[] classifyIds, String uid) {
        LinkedList<TbTopic> list = new LinkedList<>();
        //随机生成题目 random
        if ("random".equals(topicType)) {
            for (int i = 0; i < classifyIds.length; i++) {
                int classifyId = classifyIds[i];
                List<TbTopic> noDidTopicList = tbTopicDao.selectUserNoDidTopicByUidAndClassifyId(uid, classifyId, topicNum * 2);
                if (noDidTopicList == null) {
                    break;
                }
                //打乱集合
                Collections.shuffle(noDidTopicList);
                //判断集合和需求的题目大小关系
                int critical = judgeTopicSize(noDidTopicList.size(), classifyIds.length, topicNum);
                //赋值题目
                for (int j = 0; j < critical; j++) {
                    list.add(noDidTopicList.get(j));
                }
            }
            //移除多于的题目，如果题目数量过大
            ifBigRemove(list, topicNum, classifyIds.length);
        }
        //专项练习 specialItem
        if ("specialItem".equals(topicType)) {
            int classifyId = classifyIds[0];
            List<TbTopic> noDidTopicList = tbTopicDao.selectUserNoDidTopicByUidAndClassifyId(uid, classifyId, topicNum * 2);
            if (noDidTopicList != null) {
                //判断集合和需求的题目大小关系
                int critical = judgeTopicSize(noDidTopicList.size(), 1, topicNum);
                for (int j = 0; j < critical; j++) {
                    list.add(noDidTopicList.get(j));
                }
            }
        }
        //错题练习 wrongQuestion
        if ("wrongQuestion".equals(topicType)) {
            for (int i = 0; i < classifyIds.length; i++) {
                List<TbDidtopic> didtopicList = map.get(classifyIds[i]);
                if (didtopicList == null) {
                    break;
                }
                for (TbDidtopic tbDidtopic : didtopicList) {
                    if (tbDidtopic.getError() == 1) {
                        list.add(JsonUtils.jsonToPojo(jedisClient.hget("topic", String.valueOf(tbDidtopic.getTopicId())),TbTopic.class));
                    }
                    if (list.size() >= topicNum) {
                        break;
                    }
                }
            }
            ifBigRemove(list, topicNum, classifyIds.length);
        }
        return list;
    }

}
