package com.example.serverspring.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardModel {
    Integer id;
    String name;
    String doctorName;
    String doctorType;
    String cardType;

    public CardModel(Integer id, String name, String doctorName, String doctorType, String cardType) {
        this.id = id;
        this.name = name;
        this.doctorName = doctorName;
        this.doctorType = doctorType;
        this.cardType = cardType;
    }

    public CardModel() {
    }
}
