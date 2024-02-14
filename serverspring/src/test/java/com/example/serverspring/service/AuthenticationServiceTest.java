package com.example.serverspring.service;

import com.example.serverspring.entity.Doctor;
import com.example.serverspring.entity.Patient;
import com.example.serverspring.models.AnswerModel;
import com.example.serverspring.models.PatientModel;
import com.example.serverspring.repository.DefaultValueRepository;
import com.example.serverspring.repository.DoctorRepository;
import com.example.serverspring.repository.PatientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class AuthenticationServiceTest {

    @Autowired
    AuthenticationService authenticationService;
    @MockBean
    PatientRepository patientRepository;
    @MockBean
    DefaultValueRepository defaultValueRepository;
    @MockBean
    DoctorRepository doctorRepository;

    @Test
    void login() {
        Patient patient = Patient.builder().login("vadevid").password("password").build();
        Patient returnPatient = new Patient(1, "Кислицын", "Иван",
                "Александрович", "kislitsun-van@mail.ru", "vadevid",
                "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8",
                LocalDate.parse("2002-02-03"), "М");
        Mockito.doReturn(returnPatient).when(patientRepository).getByLogin(patient.getLogin());
        AnswerModel result = authenticationService.login(patient);
        assertEquals("0", result.getCode());
        assertEquals("1", result.getId());
    }

    @Test
    void loginDoctor() {
        Doctor doctor = Doctor.builder().login("doctor1").password("shiza").build();
        Doctor returnDoctor = new Doctor(1, "Винилов", "Андрей",
                "Александрович", "doctor1",
                "771d940635373649631e01e04fb257097e8f22a8118a51891fd606b979748ae5", "Терапевт");
        Mockito.doReturn(returnDoctor).when(doctorRepository).getByLogin(doctor.getLogin());
        AnswerModel result = authenticationService.loginDoctor(doctor);
        assertEquals(result.getCode(), "0");
        assertEquals(result.getId(), "1");
    }

    @Test
    void save() {
        PatientModel patient = new PatientModel("Силицын", "Кирилл", "Кириллович",
                "kir", "asd",
                "03/02/2002", "kir@mail.ru",  "М");
        Assertions.assertTrue(authenticationService.save(patient));
    }

}