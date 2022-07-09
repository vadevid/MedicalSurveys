package com.example.serverspring.service;

import com.example.serverspring.models.PatientModel;
import com.example.serverspring.repository.DefaultValueRepository;
import com.example.serverspring.repository.PatientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthenticationService2Test {
    @MockBean
    PatientRepository patientRepository;
    @Autowired
    AuthenticationService authenticationService;
    @MockBean
    DefaultValueRepository defaultValueRepository;

    @Test
    void save() {
        PatientModel patient = new PatientModel("Силицын", "Кирилл", "Кириллович",
                "kir", "asd",
                "03.02.2002", "kir@mail.ru",  "М");
        Assertions.assertTrue(authenticationService.save(patient));
    }
}
