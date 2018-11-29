package com.pojo;


public class TbDidtopic {

    private Integer didTopicId;
    private Integer topicId;
    private String userId;
    /**
     * 1 表示错题， 0 表示正确
     */
    private Integer error;
    private Integer errorOptionId;
    /**
     * 0 没有收藏 1 收藏
     */
    private Integer collection;
    private TbTopic tbTopic;

    public Integer getCollection() {
        return collection;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }

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
