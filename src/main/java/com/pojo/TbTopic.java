package com.pojo;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class TbTopic {

    private Integer topicId;
    private String topicComment;
    private Integer classifyId;
    private String analysis;
    /**
     * 用于临时保存用户选中的选项id，便于在屏幕上显示
     */
    private Integer optionId;

    private List<TbOption> optionList;

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

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

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
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


}
