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

    public Map<Integer, List<TbDidtopic>> getMap() {
        return map;
    }

    public void setMap(Map<Integer, List<TbDidtopic>> map) {
        this.map = map;
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

    public Map<Integer, Integer> getMapDidTopicByClassify() {
        return mapDidTopicByClassify;
    }

    public void setMapDidTopicByClassify(Map<Integer, Integer> mapDidTopicByClassify) {
        this.mapDidTopicByClassify = mapDidTopicByClassify;
    }
}
