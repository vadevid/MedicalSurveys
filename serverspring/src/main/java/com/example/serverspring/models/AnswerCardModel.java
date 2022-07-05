package com.example.serverspring.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerCardModel {
    Integer id;
    String answer;
    String patientName;

    public AnswerCardModel(Integer id, String answer, String patientName) {
        this.id = id;
        this.answer = answer;
        this.patientName = patientName;
    }
}
