package com.example.models;

import com.example.entity.Doctor;
import com.example.entity.Patient;
import io.micronaut.core.annotation.Introspected;

@Introspected
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
