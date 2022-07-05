package com.example.serverspring.models;

import com.example.serverspring.entity.Doctor;
import com.example.serverspring.entity.Patient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardInfoModel {
    Integer id;
    String name;
    Doctor doctor;
    Patient patient;
    String cardType;

    public CardInfoModel(Integer id, String name, Doctor doctor, Patient patient, String cardType) {
        this.id = id;
        this.name = name;
        this.doctor = doctor;
        this.patient = patient;
        this.cardType = cardType;
    }

    public CardInfoModel() {
    }
}
