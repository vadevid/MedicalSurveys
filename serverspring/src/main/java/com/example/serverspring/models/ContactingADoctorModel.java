package com.example.serverspring.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactingADoctorModel {
    private Integer patientId;
    private Integer doctorId;
    private String message;

    public ContactingADoctorModel(Integer patientId, Integer doctorId, String message) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.message = message;
    }
}
