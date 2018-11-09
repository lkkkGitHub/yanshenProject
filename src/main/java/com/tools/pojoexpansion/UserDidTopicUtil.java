package com.tools.pojoexpansion;

import com.pojo.TbDidtopic;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lk
 * 2018/11/5 13:20
 * @description:
 */
@Repository
public class UserDidTopicUtil {

    /**
     * 使用分类id，存放每个类别用户做的所有的题目的具体信息
     */
    private Map<Integer, List<TbDidtopic>> map;
    /**
     * 记录每个类型的题目错题数
     */
    private Map<Integer, Double> mapErrorTopic;
    /**
     * 记录每个类型用户的正确率
     */
    private Map<Integer, Double> mapCorrectRate;

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
    private Double errorDidTopicNum;
    /**
     * 正确率
     */
    private Double correctRate;

    public Integer getDidTopicNum() {
        return didTopicNum;
    }

    public void setDidTopicNum(Integer didTopicNum) {
        this.didTopicNum = didTopicNum;
    }

    public Double getErrorDidTopicNum() {
        return errorDidTopicNum;
    }

    public void setErrorDidTopicNum(Double errorDidTopicNum) {
        this.errorDidTopicNum = errorDidTopicNum;
        setCorrectRate();
    }

    public Double getCorrectRate() {
        return correctRate;
    }

    private void setCorrectRate() {
        if (errorDidTopicNum == 0) {
            correctRate = 0d;
        } else {
            correctRate = ((didTopicNum - errorDidTopicNum) / didTopicNum) * 100;
        }
    }

    public Map<Integer, List<TbDidtopic>> getMap() {
        return map;
    }

    public void setMap(Map<Integer, List<TbDidtopic>> map) {
        this.map = map;
    }

    public Map<Integer, Double> getMapErrorTopic() {
        return mapErrorTopic;
    }

    public void setMapErrorTopic(Map<Integer, Double> mapErrorTopic) {
        this.mapErrorTopic = mapErrorTopic;
    }

    public Map<Integer, Double> getMapCorrectRate() {
        return mapCorrectRate;
    }

    public void setMapCorrectRate(Map<Integer, Double> mapCorrectRate) {
        this.mapCorrectRate = mapCorrectRate;
    }

    public Map<Integer, Integer> getMapDidTopicByClassify() {
        return mapDidTopicByClassify;
    }

    public void setMapDidTopicByClassify(Map<Integer, Integer> mapDidTopicByClassify) {
        this.mapDidTopicByClassify = mapDidTopicByClassify;
    }
}
