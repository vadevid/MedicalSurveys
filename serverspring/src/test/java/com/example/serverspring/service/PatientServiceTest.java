package com.example.serverspring.service;

import com.example.serverspring.entity.Patient;
import com.example.serverspring.models.PatientInfoModel;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class PatientServiceTest {

    @Autowired
    PatientService patientService;

    @Test
    void patientinfo() {
        Patient patient = Patient.builder().id(1).build();
        PatientInfoModel result = patientService.patientInfo(patient);
    }

    @Test
    void setdefaultvalue() {
    }

    @Test
    void findByLogin() {
    }
}