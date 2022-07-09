package com.example.serverspring.service;

import com.example.serverspring.entity.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientService2Test {
    @Autowired
    PatientService patientService;
    @Test
    void patientinfo() {
        Assertions.assertEquals(patientService.patientinfo(new Patient(1)).getFio(), "Кислицын Иван Александрович");
    }
}
