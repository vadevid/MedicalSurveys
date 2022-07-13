package com.example.serverspring.service;

import com.example.serverspring.entity.Patient;
import com.example.serverspring.models.PatientInfoModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PatientServiceTest {

    @Autowired
    PatientService patientService;

    @Test
    void patientinfo() {
        Patient patient = new Patient(1);
        PatientInfoModel result = patientService.patientInfo(patient);
    }

    @Test
    void setdefaultvalue() {
    }

    @Test
    void findByLogin() {
    }
}