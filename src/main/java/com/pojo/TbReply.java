package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 回复表
 * @author 疯自
 */
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class TbReply {

  /**
   * 回复id
   */
  private Integer replyId;
  /**
   * 回复内容
   */
  private String replyContent;
  /**
   * 回复创建时间
   */
  private java.sql.Timestamp replyCreateDate;
  /**
   * 评论id
   */
  private Integer commentId;
  /**
   * 回复的父id
   */
  private Integer replyFatherId;

  /**
   * 发送用户id
   */
  private String uid;

  /**
   * 回复的用户信息
   */
  private TbUser tbUser;

  /**
   * 题目id
   */
  private Integer topicId;

  /**
   * 题目信息
   */
  private TbTopic tbTopic;

  /**
   * 接受用户id
   */
  private String toUid;

  /**
   * 是否已读
   */
  private Integer isRead;

  public Integer getIsRead() {
    return isRead;
  }

  public void setIsRead(Integer isRead) {
    this.isRead = isRead;
  }

  public String getToUid() {
    return toUid;
  }

  public void setToUid(String toUid) {
    this.toUid = toUid;
  }

  public TbTopic getTbTopic() {
    return tbTopic;
  }

  public void setTbTopic(TbTopic tbTopic) {
    this.tbTopic = tbTopic;
  }

  public Integer getTopicId() {
    return topicId;
  }

  public void setTopicId(Integer topicId) {
    this.topicId = topicId;
  }

  public TbUser getTbUser() {
    return tbUser;
  }

  public void setTbUser(TbUser tbUser) {
    this.tbUser = tbUser;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public Integer getReplyId() {
    return replyId;
  }

  public void setReplyId(Integer replyId) {
    this.replyId = replyId;
  }


  public String getReplyContent() {
    return replyContent;
  }

  public void setReplyContent(String replyContent) {
    this.replyContent = replyContent;
  }


  public java.sql.Timestamp getReplyCreateDate() {
    return replyCreateDate;
  }

  public void setReplyCreateDate(java.sql.Timestamp replyCreateDate) {
    this.replyCreateDate = replyCreateDate;
  }


  public Integer getCommentId() {
    return commentId;
  }

  public void setCommentId(Integer commentId) {
    this.commentId = commentId;
  }


  public Integer getReplyFatherId() {
    return replyFatherId;
  }

  public void setReplyFatherId(Integer replyFatherId) {
    this.replyFatherId = replyFatherId;
  }

}
