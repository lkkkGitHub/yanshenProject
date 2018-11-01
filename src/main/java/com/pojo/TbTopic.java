package com.pojo;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class TbTopic {

    private Integer topicId;
    private String topicComment;
    private Integer classifyId;

    private List<TbOption> optionList;

    public List<TbOption> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<TbOption> optionList) {
        this.optionList = optionList;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }


    public String getTopicComment() {
        return topicComment;
    }

    public void setTopicComment(String topicComment) {
        this.topicComment = topicComment;
    }


    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    @Override
    public String toString() {
        return "TbTopic{" +
                "topicId=" + topicId +
                ", topicComment='" + topicComment + '\'' +
                ", classifyId=" + classifyId +
                ", optionList=" + optionList +
                '}';
    }
}
