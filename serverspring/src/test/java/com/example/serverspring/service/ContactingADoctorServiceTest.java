package com.example.serverspring.service;

import com.example.serverspring.entity.ContactingADoctor;
import com.example.serverspring.models.ContactingADoctorModel;
import com.example.serverspring.repository.ContactingADoctorRepository;
import com.example.serverspring.repository.DoctorRepository;
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
class ContactingADoctorServiceTest {

    @Autowired
    ContactingADoctorService contactingADoctorService;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;
    @MockBean
    ContactingADoctorRepository contactingADoctorRepository;

    @Test
    void save() {
        Assertions.assertTrue(contactingADoctorService.save(new ContactingADoctorModel(1, 1, "Сидеть больно")));
    }

    @Test
    void getMessage() {
        Assertions.assertEquals(contactingADoctorService.getMessage(new ContactingADoctor(3, "Покраснение на пальце", doctorRepository.getById(2), patientRepository.getById(1))).getText(), "Покраснение на пальце");
    }
}