package com.pojo;


public class TbDidtopic {

  private long didTopicId;
  private long topicId;
  private String userId;
  private long error;
  private long errorOptionId;


  public long getDidTopicId() {
    return didTopicId;
  }

  public void setDidTopicId(long didTopicId) {
    this.didTopicId = didTopicId;
  }


  public long getTopicId() {
    return topicId;
  }

  public void setTopicId(long topicId) {
    this.topicId = topicId;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public long getError() {
    return error;
  }

  public void setError(long error) {
    this.error = error;
  }


  public long getErrorOptionId() {
    return errorOptionId;
  }

  public void setErrorOptionId(long errorOptionId) {
    this.errorOptionId = errorOptionId;
  }

}
