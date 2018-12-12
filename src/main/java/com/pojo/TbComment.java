package com.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author lk
 * @date 2018/12/12 15:44
 */
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class TbComment {

    /**
     * 评论id
     */
    private Integer commentId;
    /**
     * 评论内容
     */
    private String commentContent;
    /***
     * 时间
     */
    private java.sql.Timestamp commentCreateDate;
    /**
     * 题目id
     */
    private Integer topicId;
    /**
     * 用户id
     */
    private String uid;

    /**
     * 关联用户信息
     */
    private TbUser tbUser;

    /**
     * 评论的数量
     */
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public TbUser getTbUser() {
        return tbUser;
    }

    public void setTbUser(TbUser tbUser) {
        this.tbUser = tbUser;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }


    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }


    public java.sql.Timestamp getCommentCreateDate() {
        return commentCreateDate;
    }

    public void setCommentCreateDate(java.sql.Timestamp commentCreateDate) {
        this.commentCreateDate = commentCreateDate;
    }


    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}
