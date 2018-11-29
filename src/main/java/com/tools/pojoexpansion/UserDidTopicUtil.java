package com.tools.pojoexpansion;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author lk
 * 2018/11/5 13:20
 * @description:
 */
@Repository
public class UserDidTopicUtil {

    /**
     * 记录每个类型的题目错题数
     */
    private Map<Integer, Integer> mapErrorTopic;
    /**
     * 记录每个类型用户的正确率
     */
    private Map<Integer, Long> mapCorrectRate;

    /**
     * 记录每个类型的作题数量
     */
    private Map<Integer, Integer> mapDidTopicByClassify;

    /**
     * 用户做过的全部题目数量
     */
    private Integer didTopicNum;
    /**
     * 用户全部做错的题目数量
     */
    private Integer errorDidTopicNum;
    /**
     * 正确率
     */
    private Long correctRate;

    public Integer getDidTopicNum() {
        return didTopicNum;
    }

    public void setDidTopicNum(Integer didTopicNum) {
        this.didTopicNum = didTopicNum;
    }

    public Integer getErrorDidTopicNum() {
        return errorDidTopicNum;
    }

    public void setErrorDidTopicNum(Integer errorDidTopicNum) {
        this.errorDidTopicNum = errorDidTopicNum;
        setCorrectRate();
    }

    public Long getCorrectRate() {
        return correctRate;
    }

    private void setCorrectRate() {
        if (errorDidTopicNum == 0) {
            correctRate = 0L;
        } else {
            correctRate = Math.round((Double.valueOf(didTopicNum - errorDidTopicNum) / didTopicNum) * 100);
        }
    }

    public Map<Integer, Integer> getMapErrorTopic() {
        return mapErrorTopic;
    }

    public void setMapErrorTopic(Map<Integer, Integer> mapErrorTopic) {
        this.mapErrorTopic = mapErrorTopic;
    }

    public Map<Integer, Long> getMapCorrectRate() {
        return mapCorrectRate;
    }

    public void setMapCorrectRate(Map<Integer, Long> mapCorrectRate) {
        this.mapCorrectRate = mapCorrectRate;
    }

    /**
     * 重载设置正确率方法 通过该方法重设正确率
     */
    public void setMapCorrectRate() {
        for (int i = 1; i < mapDidTopicByClassify.size() + 1; i++) {
            Double correctRate = ((Double.valueOf(mapDidTopicByClassify.get(i)) - mapErrorTopic.get(i))
                    / mapDidTopicByClassify.get(i)) * 100;
            mapCorrectRate.put(i, Math.round(correctRate));
        }
    }

    public Map<Integer, Integer> getMapDidTopicByClassify() {
        return mapDidTopicByClassify;
    }

    public void setMapDidTopicByClassify(Map<Integer, Integer> mapDidTopicByClassify) {
        this.mapDidTopicByClassify = mapDidTopicByClassify;
        setMapCorrectRate();
    }
}
