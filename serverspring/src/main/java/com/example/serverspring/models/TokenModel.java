package com.example.serverspring.models;

public enum TokenModel {
    TYPE("clientType"), ID("userID"), NAME("username"), CREATE("token_create_date"), EXPIRATION("token_expiration_date");
    private String text;
    TokenModel(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
