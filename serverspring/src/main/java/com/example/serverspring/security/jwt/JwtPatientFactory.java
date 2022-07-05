package com.example.serverspring.security.jwt;

import com.example.serverspring.entity.Patient;

public final class JwtPatientFactory {
    public JwtPatientFactory(){}

    public static JwtPatient create(Patient patient) {
        return new JwtPatient(patient.getId(), patient.getLogin(),
                patient.getSecondName(), patient.getFirstName(),
                patient.getMiddleName(), patient.getPassword(),
                patient.getEmail(), patient.getBirthdate(), patient.getSex());
    }
}
