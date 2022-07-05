package com.example.serverspring.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageModel {
    Integer id;
    String patientName;
    String text;

    public MessageModel(Integer id, String patientName, String text) {
        this.id = id;
        this.patientName = patientName;
        this.text = text;
    }
}
