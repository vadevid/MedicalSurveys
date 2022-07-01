package com.example.models;

public class AnswerModel {
    public AnswerModel(String code, String id, String token) {
        this.code = code;
        this.id = id;
        this.token = token;
    }

    public AnswerModel(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String code;
    private String id;
    private String token;
}
