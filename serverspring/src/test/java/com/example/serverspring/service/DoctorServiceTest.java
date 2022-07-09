package com.example.serverspring.service;

import com.example.serverspring.entity.ContactingADoctor;
import com.example.serverspring.entity.Doctor;
import com.example.serverspring.entity.Patient;
import com.example.serverspring.repository.ContactingADoctorRepository;
import com.example.serverspring.repository.DoctorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class DoctorServiceTest {

    @Autowired
    DoctorService doctorService;
    @MockBean
    ContactingADoctorRepository contactingADoctorRepository;
    @MockBean
    DoctorRepository doctorRepository;

    @Test
    void getAllMessage() {
        List<ContactingADoctor> contactingADoctorList = new ArrayList<>();
        ContactingADoctor contactingADoctor = new ContactingADoctor(3, "Покраснение на пальце", new Doctor(), new Patient());
        contactingADoctorList.add(contactingADoctor);
        Mockito.doReturn(contactingADoctorList).when(contactingADoctorRepository).findAllByDoctorId(1);
        Assertions.assertEquals(doctorService.getAllMessage(1).size(), 1);
    }

    @Test
    void findByLogin() {
        Doctor doctor = new Doctor(1, "Винилов", "Андрей", "Александрович",
                "doctor1", "771d940635373649631e01e04fb257097e8f22a8118a51891fd606b979748ae5", "Терапевт");
        Mockito.doReturn(doctor).when(doctorRepository).getByLogin("doctor1");
        Assertions.assertEquals(doctorService.findByLogin("doctor1").getFIO(), "Винилов Андрей Александрович");
    }
}