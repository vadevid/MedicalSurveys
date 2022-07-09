package com.example.serverspring.service;

import com.example.serverspring.entity.Doctor;
import com.example.serverspring.entity.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class AuthenticationServiceTest {

    @Autowired
    AuthenticationService authenticationService;
//    @MockBean
//    PatientRepository patientRepository;

    @Test
    void login() {
        Patient patient = new Patient("vadevid", "password");
        Assertions.assertEquals(authenticationService.login(patient).getCode(), "0");
//        PatientRepository patientRepository = Mockito.spy(PatientRepository.class);
//        Patient patient = new Patient("vadevid", "password");
//        Patient returnPatient = new Patient(1, "Кислицын", "Иван",
//                "Александрович", "kislitsun-van@mail.ru", "vadevid",
//                "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8",
//                LocalDate.parse("2002-02-03"), "М");
//        Mockito.doReturn(returnPatient).when(patientRepository).getByLogin(patient.getLogin());
//        Assertions.assertEquals("0", authenticationService.login(patient).getCode());
    }

    @Test
    void loginDoctor() {
        Doctor doctor = new Doctor("doctor1", "shiza");
        Assertions.assertEquals(authenticationService.loginDoctor(doctor).getCode(), "0");
    }

}