package com.pojo;

/**
 * 回复表
 */
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
   * 用户id
   */
  private String uid;

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
