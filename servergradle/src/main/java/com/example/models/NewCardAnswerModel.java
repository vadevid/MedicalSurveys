package com.example.models;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class NewCardAnswerModel {
    private Integer cardId;
    private String value;

    public NewCardAnswerModel(Integer cardId, String value) {
        this.cardId = cardId;
        this.value = value;
    }

    public NewCardAnswerModel() {
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
