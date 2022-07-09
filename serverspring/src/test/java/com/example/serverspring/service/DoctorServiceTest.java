package com.example.serverspring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class DoctorServiceTest {

    @Autowired
    DoctorService doctorService;

    @Test
    void getAllMessage() {
        Assertions.assertNotNull(doctorService.getAllMessage(1));
    }

    @Test
    void findByLogin() {
        Assertions.assertEquals(doctorService.findByLogin("doctor1").getFIO(), "Винилов Андрей Александрович");
    }
}