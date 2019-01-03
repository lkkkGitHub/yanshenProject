package com.pojo;

public class TbOption {

    private Integer optionId;
    private String optionComment;
    private Integer topicId;
    private Integer correct;

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }


    public String getOptionComment() {
        return optionComment;
    }

    public void setOptionComment(String optionComment) {
        this.optionComment = optionComment;
    }


    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    @Override
    public String toString() {
        return "TbOption{" +
                "optionId=" + optionId +
                ", optionComment='" + optionComment + '\'' +
                ", topicId=" + topicId +
                ", correct=" + correct +
                '}';
    }
}
