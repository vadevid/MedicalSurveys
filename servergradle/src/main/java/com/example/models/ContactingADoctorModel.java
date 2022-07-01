package com.example.models;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class ContactingADoctorModel {
    private Integer patientId;
    private Integer doctorId;
    private String message;

    public ContactingADoctorModel(Integer patientId, Integer doctorId, String message) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.message = message;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
