package com.service.impl;

import com.dao.TbDidtopicDao;
import com.pojo.TbClassify;
import com.pojo.TbDidtopic;
import com.pojo.TbOption;
import com.pojo.TbTopic;
import com.service.ClassifyService;
import com.service.DidtopicService;
import com.tools.finaltools.TopicFinalTool;
import com.tools.pojoexpansion.UserDidTopicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        //记录每个类型的题目错题数
        Map<Integer, Integer> mapErrorTopic = new HashMap<>(tbClassifyList.size());
        //记录每个类型用户的正确率
        Map<Integer, Long> mapCorrectRate = new HashMap<>(tbClassifyList.size());
        //记录每个类型的作题数量
        Map<Integer, Integer> mapDidTopicByClassify = new HashMap<>(tbClassifyList.size());
        //记录用户作题总数
        int countAllDidTopic = new Integer(0);
        //记录用户作题错题的总数
        Integer errorAllCount = new Integer(0);
        for (int i = 0; i < tbClassifyList.size(); i++) {
            //获取用户每个类型下做的题目信息
            List<TbDidtopic> list = didtopicDao.findDidTopicByUserIdAndClassifyId(userId, i + 1);
            mapDidTopicByClassify.put(i + 1, list.size());
            countAllDidTopic += list.size();
            //记录用户每个类型的错题数
            Integer errorCount = new Integer(0);
            for (TbDidtopic tbDidtopic : list) {
                if (tbDidtopic.getError() == 1) {
                    errorCount++;
                }
            }
            errorAllCount += errorCount;
            mapErrorTopic.put(i + 1, errorCount);
            if (list.size() == 0) {
                mapCorrectRate.put(i + 1, 0L);
            } else {
                Double correctRate = ((Double.valueOf(list.size()) - errorCount) / list.size()) * 100;
                mapCorrectRate.put(i + 1, Math.round(correctRate));
            }
        }
        userDidTopicUtil.setDidTopicNum(countAllDidTopic);
        userDidTopicUtil.setErrorDidTopicNum(errorAllCount);
        userDidTopicUtil.setMapCorrectRate(mapCorrectRate);
        userDidTopicUtil.setMapErrorTopic(mapErrorTopic);
        userDidTopicUtil.setMapDidTopicByClassify(mapDidTopicByClassify);
        return userDidTopicUtil;
    }

    @Transactional
    @Override
    public List<TbDidtopic> commitTopic(List<TbTopic> topicList, String topicType, String uid,
                                        UserDidTopicUtil userDidTopicUtil) {
        List<TbDidtopic> didTopicList = new ArrayList<>(topicList.size());
        int i = 0;
        if (!TopicFinalTool.WRONG_QUESTION.equals(topicType)) {
            Map<Integer, Integer> mapDidTopicByClassify = userDidTopicUtil.getMapDidTopicByClassify();
            Map<Integer, Integer> mapErrorTopic = userDidTopicUtil.getMapErrorTopic();
            userDidTopicUtil.setDidTopicNum(userDidTopicUtil.getDidTopicNum() + topicList.size());
            for (TbTopic topic : topicList) {
                //开始维护UserDidTopicUtil
                Integer classifyId = topic.getClassifyId();
                mapDidTopicByClassify.put(classifyId, mapDidTopicByClassify.get(classifyId) + 1);
                TbDidtopic tbDidtopic = new TbDidtopic();
                List<TbOption> optionList = topic.getOptionList();
                tbDidtopic.setTopicId(topic.getTopicId());
                tbDidtopic.setUserId(uid);
                tbDidtopic.setTbTopic(topic);
                for (TbOption option : optionList) {
                    if (TopicFinalTool.CORRECT.equals(option.getCorrect())) {
                        if (option.getOptionId().equals(topic.getOptionId())) {
                            tbDidtopic.setError(0);
                            tbDidtopic.setErrorOptionId(-1);
                        } else {
                            tbDidtopic.setError(1);
                            if (topic.getOptionId() == null) {
                                tbDidtopic.setErrorOptionId(-1);
                            } else {
                                tbDidtopic.setErrorOptionId(topic.getOptionId());
                            }
                            mapErrorTopic.put(classifyId, mapErrorTopic.get(classifyId) + 1);
                            userDidTopicUtil.setErrorDidTopicNum(userDidTopicUtil.getErrorDidTopicNum() + 1);
                        }
                        didTopicList.add(tbDidtopic);
                    }
                }
            }
            userDidTopicUtil.setMapErrorTopic(mapErrorTopic);
            userDidTopicUtil.setMapDidTopicByClassify(mapDidTopicByClassify);
            i = didtopicDao.insertList(didTopicList);
            if (i == topicList.size()) {
                return didTopicList;
            } else {
                try {
                    throw new Exception("答卷提交统计事务执行失败");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
            //错题练习即为更新数据库字段，否则即使插入
//        if (!TopicFinalTool.WRONG_QUESTION.equals(topicType)) {
        } else {
            for (TbTopic topic : topicList) {
                TbDidtopic tbDidtopic = new TbDidtopic();
                List<TbOption> optionList = topic.getOptionList();
                tbDidtopic.setTopicId(topic.getTopicId());
                tbDidtopic.setUserId(uid);
                tbDidtopic.setTbTopic(topic);
                for (TbOption option : optionList) {
                    if (option.getCorrect() == 1) {
                        if (option.getOptionId().equals(topic.getOptionId())) {
                            tbDidtopic.setError(0);
                            tbDidtopic.setErrorOptionId(-1);
                        } else {
                            tbDidtopic.setError(1);
                            if (topic.getOptionId() == null) {
                                tbDidtopic.setErrorOptionId(-1);
                            } else {
                                tbDidtopic.setErrorOptionId(topic.getOptionId());
                            }
                        }
                        didTopicList.add(tbDidtopic);
                    }
                }
            }
            didtopicDao.updateDidTopic(didTopicList);
            return didTopicList;
        }
    }

}
