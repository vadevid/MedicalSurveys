package com.example.models;

public class CardAnswerModel {
    Integer id;
    String valueName;
    String answer;
    String answerDate;
    Double minValue;
    Double maxValue;

    public CardAnswerModel(Integer id, String valueName, String answer, String answerDate, Double minValue, Double maxValue) {
        this.id = id;
        this.valueName = valueName;
        this.answer = answer;
        this.answerDate = answerDate;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(String answerDate) {
        this.answerDate = answerDate;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }
}
