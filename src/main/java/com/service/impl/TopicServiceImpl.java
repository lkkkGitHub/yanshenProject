package com.service.impl;

import com.dao.TbTopicDao;
import com.pojo.TbClassify;
import com.pojo.TbTopic;
import com.service.ClassifyService;
import com.service.TopicService;
import com.tools.finaltools.ClassifyFinalTool;
import com.tools.finaltools.TopicFinalTool;
import com.tools.utils.JsonUtils;
import com.tools.utils.jedis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
            Integer integer = JsonUtils.jsonToPojo(jedisClient.hget(ClassifyFinalTool.CLASSIFY_NUM, String.valueOf(x)), Integer.class);
            if (integer == null) {
                List<TbTopic> tbTopicList = tbTopicDao.selectTopicByClassifyId(x);
                jedisClient.hset(ClassifyFinalTool.CLASSIFY_NUM, String.valueOf(x), String.valueOf(tbTopicList.size()));
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
     * @param topicNum 需求题目总数量
     * @return 实际集合的容量
     */
    private int judgeTopicSize(int classifyIdsLength, int topicNum) {
        int i = topicNum / classifyIdsLength;
        if (topicNum % classifyIdsLength == 0) {
            return i;
        } else {
            return ++i;
        }
    }

    @Override
    public LinkedList<TbTopic> getTopicToExercise(int topicNum, String topicType, int[] classifyIds, String uid) {
        LinkedList<TbTopic> list = new LinkedList<>();
        int length = classifyIds.length;
        int i = judgeTopicSize(length, topicNum);
        //随机生成题目 random
        if (TopicFinalTool.RANDOM.equals(topicType)) {
            for (int classifyId : classifyIds) {
                List<TbTopic> noDidTopicList =
                        tbTopicDao.selectUserNoDidTopicByUidAndClassifyId(uid, classifyId, i * 2);
                if (noDidTopicList == null) {
                    break;
                }
                //打乱集合
                Collections.shuffle(noDidTopicList);
                list.addAll(noDidTopicList.stream().limit(i).collect(Collectors.toCollection(LinkedList::new)));
            }
            //移除多于的题目，如果题目数量过大
            ifBigRemove(list, topicNum, length);
        }
        //专项练习 specialItem
        if (TopicFinalTool.SPECIAL_ITEM.equals(topicType)) {
            int classifyId = classifyIds[0];
            list.addAll(tbTopicDao.selectUserNoDidTopicByUidAndClassifyId(uid, classifyId, topicNum));
        }
        //错题练习 wrongQuestion
        //暂时做了当有类别的错题数量不足时，该题目缺少一个，总题数少一个；随机练习也将如此
        //以后希望在该类别题目少了之后，其他类型的题目数量多，则通过起来类别弥补总题数的缺失
        if (TopicFinalTool.WRONG_QUESTION.equals(topicType)) {
            for (int classifyId : classifyIds) {
                list.addAll(tbTopicDao.selectErrorTopic(uid, 1, classifyId, i));
            }
            ifBigRemove(list, topicNum, 1);
        }
        return list;
    }

    @Override
    public TbTopic getTopic(Integer topicId) {
        return tbTopicDao.selectTopicByTopicId(topicId);
    }
}
