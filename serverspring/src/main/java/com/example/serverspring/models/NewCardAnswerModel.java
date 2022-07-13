package com.example.serverspring.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
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
