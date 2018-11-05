package com.tools.pojoexpansion;

/**
 * @author lk
 * 2018/11/5 13:20
 * @description:
 */
public class UserDidTopicUtil {
    /**
     * 用户做过的全部题目数量
     */
    private Integer didTopicNum;
    /**
     * 用户做错的题目数量
     */
    private Integer errorDidTopicNum;
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

    public Integer getErrorDidTopicNum() {
        return errorDidTopicNum;
    }

    public void setErrorDidTopicNum(Integer errorDidTopicNum) {
        this.errorDidTopicNum = errorDidTopicNum;
        setCorrectRate();
    }

    public Double getCorrectRate() {
        return correctRate;
    }

    public void setCorrectRate() {
        if (errorDidTopicNum == 0) {
            correctRate = 0d;
        } else {
            correctRate = Double.valueOf((didTopicNum - errorDidTopicNum) / errorDidTopicNum);
        }
    }
}
