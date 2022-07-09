package com.example.serverspring.service;

import com.example.serverspring.models.DefaultValueModel;
import com.example.serverspring.repository.DefaultValueRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class PatientServiceTest {

    @MockBean
    DefaultValueRepository defaultValueRepository;

    @Autowired
    PatientService patientService;

    @Test
    void setdefaultvalue() {
        Assertions.assertTrue(patientService.setdefaultvalue(new DefaultValueModel(1, "180", "76")));
    }

    @Test
    void findByLogin() {
        Assertions.assertEquals(patientService.findByLogin("vadevid").getFIO(), "Кислицын Иван Александрович");
    }
}