package com.example.models;

import io.micronaut.core.annotation.Introspected;

@Introspected
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

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
