package com.example.serverspring.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
