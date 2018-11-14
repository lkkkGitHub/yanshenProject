package com.service.impl;

import com.dao.TbDidtopicDao;
import com.pojo.TbClassify;
import com.pojo.TbDidtopic;
import com.pojo.TbOption;
import com.pojo.TbTopic;
import com.service.ClassifyService;
import com.service.DidtopicService;
import com.tools.pojoexpansion.UserDidTopicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lk
 * 2018/11/5 11:45
 * @description:
 */
@Service
public class DidtopicServiceImpl implements DidtopicService {

    @Autowired
    private TbDidtopicDao didtopicDao;

    @Autowired
    private UserDidTopicUtil userDidTopicUtil;

    @Autowired
    private ClassifyService classifyServiceImpl;

    @Override
    public UserDidTopicUtil findDidTopicByUserIdAndClassifyId(String userId) {
        //获取分类的list集合，该方法中已经封装好了缓存机制
        List<TbClassify> tbClassifyList = classifyServiceImpl.allClassify();
        //使用分类id，存放每个类别用户做的所有的题目的具体信息
        Map<Integer, List<TbDidtopic>> map = new HashMap<>(tbClassifyList.size());
        //记录每个类型的题目错题数
        Map<Integer, Double> mapErrorTopic = new HashMap<>(tbClassifyList.size());
        //记录每个类型用户的正确率
        Map<Integer, Double> mapCorrectRate = new HashMap<>(tbClassifyList.size());
        //记录每个类型的作题数量
        Map<Integer, Integer> mapDidTopicByClassify = new HashMap<>(tbClassifyList.size());
        //记录用户作题总数
        int countAllDidTopic = 0;
        //记录用户作题错题的总数
        double errorAllCount = 0;
        for (int i = 0; i < tbClassifyList.size(); i++) {
            //获取用户每个类型下做的题目信息
            List<TbDidtopic> list = didtopicDao.findDidTopicByUserIdAndClassifyId(userId, i + 1);
            map.put(i + 1, list);
            mapDidTopicByClassify.put(i + 1, list.size());
            countAllDidTopic += list.size();
            //记录用户每个类型的错题数
            double errorCount = 0d;
            for (TbDidtopic tbDidtopic: list) {
                if (tbDidtopic.getError() == 0) {
                    errorCount++;
                }
            }
            errorAllCount += errorCount;
            mapErrorTopic.put(i + 1, errorCount);
            if (list.size() == 0) {
                mapCorrectRate.put(i + 1, (double) 0);
            } else {
                mapCorrectRate.put(i + 1, ((list.size() - errorCount) / list.size()) * 100);
            }
        }
        userDidTopicUtil.setDidTopicNum(countAllDidTopic);
        userDidTopicUtil.setErrorDidTopicNum(errorAllCount);
        userDidTopicUtil.setMap(map);
        userDidTopicUtil.setMapCorrectRate(mapCorrectRate);
        userDidTopicUtil.setMapErrorTopic(mapErrorTopic);
        userDidTopicUtil.setMapDidTopicByClassify(mapDidTopicByClassify);
        return userDidTopicUtil;
    }

    @Override
    public List<TbDidtopic> commitTopic(List<TbTopic> topicList, String uid) {
        List<TbDidtopic> didtopicList = new ArrayList<>(topicList.size());
        TbDidtopic tbDidtopic = new TbDidtopic();
        for (TbTopic topic : topicList) {
            List<TbOption> optionList = topic.getOptionList();
            tbDidtopic.setTopicId(topic.getTopicId());
            tbDidtopic.setUserId(uid);
            for (TbOption option : optionList) {
                if (option.getCorrect() == 1) {
                    if (option.getOptionId().equals(topic.getOptionId())) {
                        didtopicList.add(tbDidtopic);
                    } else {
                        tbDidtopic.setError(0);
                        tbDidtopic.setErrorOptionId(topic.getOptionId());
                        didtopicList.add(tbDidtopic);
                    }
                }
            }
        }
        int i = didtopicDao.insertList(didtopicList);
        if (i == topicList.size()) {
            return didtopicList;
        }
        return null;
    }
}
