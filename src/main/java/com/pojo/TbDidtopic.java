package com.pojo;


public class TbDidtopic {

    private Integer didTopicId;
    private Integer topicId;
    private String userId;
    /**
     * 0 表示错题，1 表示正确
     */
    private Integer error;
    private Integer errorOptionId;
    private TbTopic tbTopic;

    public TbTopic getTbTopic() {
        return tbTopic;
    }

    public void setTbTopic(TbTopic tbTopic) {
        this.tbTopic = tbTopic;
    }

    public Integer getDidTopicId() {
        return didTopicId;
    }

    public void setDidTopicId(Integer didTopicId) {
        this.didTopicId = didTopicId;
    }


    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }


    public Integer getErrorOptionId() {
        return errorOptionId;
    }

    public void setErrorOptionId(Integer errorOptionId) {
        this.errorOptionId = errorOptionId;
    }

}
