package com.example.serverspring.service;

import com.example.serverspring.models.NewCardAnswerModel;
import com.example.serverspring.models.NewCardModel;
import com.example.serverspring.repository.CardAnswerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CardServiceTest {

    @Autowired
    CardService cardService;
    @MockBean
    CardAnswerRepository cardAnswerRepository;

    @Test
    void findAllByPatientId() {
        Assertions.assertNotNull(cardService.findAllByPatientId(1));
    }

    @Test
    void findAllByDoctorId() {
        Assertions.assertNotNull(cardService.findAllByDoctorId(1));
    }

    @Test
    void getById() {
        Assertions.assertNotNull(cardService.getById(2));
    }

    @Test
    void getAllAnswer() {
        Assertions.assertNotNull(cardService.getAllAnswer(2));
    }

    @Test
    void newvalue() {
        Assertions.assertTrue(cardService.newvalue(new NewCardAnswerModel(2, "45")));
    }

    @Test
    void save() {
        Assertions.assertTrue(cardService.save(new NewCardModel("Шиза", 3, "TextField")));
    }
}