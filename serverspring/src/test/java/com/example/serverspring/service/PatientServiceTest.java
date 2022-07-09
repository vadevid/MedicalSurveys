package com.example.serverspring.service;

import com.example.serverspring.entity.DefaultValue;
import com.example.serverspring.entity.Patient;
import com.example.serverspring.models.DefaultValueModel;
import com.example.serverspring.repository.DefaultValueRepository;
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

@RunWith(SpringRunner.class)
@SpringBootTest
class PatientServiceTest {

    @MockBean
    DefaultValueRepository defaultValueRepository;
    @MockBean
    PatientRepository patientRepository;

    @Autowired
    PatientService patientService;

    @Test
    void setdefaultvalue() {
        Assertions.assertTrue(patientService.setdefaultvalue(new DefaultValueModel(1, "180", "76")));
    }

    @Test
    void findByLogin() {
        Patient returnPatient = new Patient(1, "Кислицын", "Иван",
                "Александрович", "kislitsun-van@mail.ru", "vadevid",
                "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8",
                LocalDate.parse("2002-02-03"), "М");
        Mockito.doReturn(returnPatient).when(patientRepository).findByLogin("vadevid");
        Assertions.assertEquals(patientService.findByLogin("vadevid").getFIO(), "Кислицын Иван Александрович");
    }

    @Test
    void patientinfo() {
        Patient returnPatient = new Patient(1, "Кислицын", "Иван",
                "Александрович", "kislitsun-van@mail.ru", "vadevid",
                "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8",
                LocalDate.parse("2002-02-03"), "М");
        DefaultValue returnDefaultValue = new DefaultValue(returnPatient, 185, 75);
        Mockito.doReturn(returnPatient).when(patientRepository).getById(1);
        Mockito.doReturn(returnDefaultValue).when(defaultValueRepository).findFirstByPatientOrderByIdDesc(returnPatient);
        Assertions.assertEquals("21.9", patientService.patientinfo(new Patient(1)).getMass_index().substring(0, 4));
    }
}