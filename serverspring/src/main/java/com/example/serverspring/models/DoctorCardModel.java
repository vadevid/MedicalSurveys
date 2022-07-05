package com.example.serverspring.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorCardModel {
    Integer id;
    String name;
    String patientName;
    String cardType;

    public DoctorCardModel(Integer id, String name, String patientName, String cardType) {
        this.id = id;
        this.name = name;
        this.patientName = patientName;
        this.cardType = cardType;
    }
}
