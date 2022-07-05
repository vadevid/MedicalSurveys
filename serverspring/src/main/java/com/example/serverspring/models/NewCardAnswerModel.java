package com.example.serverspring.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewCardAnswerModel {
    private Integer cardId;
    private String value;

    public NewCardAnswerModel(Integer cardId, String value) {
        this.cardId = cardId;
        this.value = value;
    }

    public NewCardAnswerModel() {
    }
}
