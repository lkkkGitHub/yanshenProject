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
     * @param size     集合数量
     * @param topicNum 需求题目总数量
     * @return 实际集合的容量
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

    /**
     * 开始为LinkedeList 集合赋值
     * @param list 传入数据库查出的题目
     * @param length 类型数组的长度
     * @param topicNum 需求题目数量
     * @return LinkedList集合
     */
    private LinkedList<TbTopic> setLinkedList(List<TbTopic> list, Integer length, Integer topicNum) {
        LinkedList<TbTopic> linkedList = new LinkedList<>();
        int critical = judgeTopicSize(list.size(), length, topicNum);
        for (int j = 0; j < critical; j++) {
            linkedList.add(list.get(j));
        }
        return linkedList;
    }

    @Override
    public LinkedList<TbTopic> getTopicToExercise(int topicNum, String topicType, int[] classifyIds, String uid) {
        LinkedList<TbTopic> list = new LinkedList<>();
        //随机生成题目 random
        if (TopicFinalTool.RANDOM.equals(topicType)) {
            for (int i = 0; i < classifyIds.length; i++) {
                int classifyId = classifyIds[i];
                List<TbTopic> noDidTopicList =
                        tbTopicDao.selectUserNoDidTopicByUidAndClassifyId(uid, classifyId, topicNum * 2);
                if (noDidTopicList == null) {
                    break;
                }
                //打乱集合
                Collections.shuffle(noDidTopicList);
                //开始赋值
                list.addAll(setLinkedList(noDidTopicList, classifyIds.length, topicNum));
            }
            //移除多于的题目，如果题目数量过大
            ifBigRemove(list, topicNum, classifyIds.length);
        }
        //专项练习 specialItem
        if (TopicFinalTool.SPECIAL_ITEM.equals(topicType)) {
            int classifyId = classifyIds[0];
            List<TbTopic> noDidTopicList = tbTopicDao.selectUserNoDidTopicByUidAndClassifyId(uid, classifyId, topicNum * 2);
            if (noDidTopicList != null) {
                list.addAll(setLinkedList(noDidTopicList, 1, topicNum));
            }
        }
        //错题练习 wrongQuestion
        //暂时做了当有类别的错题数量不足时，该题目缺少一个，总题数少一个；随机练习也将如此
        //以后希望在该类别题目少了之后，其他类型的题目数量多，则通过起来类别弥补总题数的缺失
        if (TopicFinalTool.WRONG_QUESTION.equals(topicType)) {
            for (int i = 1; i < classifyIds.length + 1; i++) {
                List<TbTopic> noDidTopicList = tbTopicDao.selectErrorTopic(uid, 1, classifyIds[i - 1]);
                list.addAll(setLinkedList(noDidTopicList, classifyIds.length, topicNum));
            }
            ifBigRemove(list, topicNum, classifyIds.length);
        }
        return list;
    }

}
