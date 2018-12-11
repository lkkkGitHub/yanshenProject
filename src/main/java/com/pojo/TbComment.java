package com.pojo;


/**
 * @author 疯自
 */
public class TbComment {

    private Long commentId;
    private String commentContent;
    private java.sql.Timestamp commentCreateDate;
    private Long topicId;
    private String uid;

    private TbUser tbUser;

    public TbUser getTbUser() {
        return tbUser;
    }

    public void setTbUser(TbUser tbUser) {
        this.tbUser = tbUser;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
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


    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}
