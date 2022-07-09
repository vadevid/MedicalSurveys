package com.example.serverspring.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerModel {
    public AnswerModel(String code, String id, String token) {
        this.code = code;
        this.id = id;
        this.token = token;
    }

    public AnswerModel(String code) {
        this.code = code;
    }

    private String code;
    private String id;
    private String token;

    public AnswerModel(String code, String id) {
        this.code = code;
        this.id = id;
    }
}
