package com.example.models;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class MessageModel {
    Integer id;
    String patientName;
    String text;

    public MessageModel(Integer id, String patientName, String text) {
        this.id = id;
        this.patientName = patientName;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
