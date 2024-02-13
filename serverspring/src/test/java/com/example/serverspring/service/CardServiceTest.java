package com.example.serverspring.service;

import com.example.serverspring.entity.*;
import com.example.serverspring.models.NewCardAnswerModel;
import com.example.serverspring.models.NewCardModel;
import com.example.serverspring.repository.CardAnswerRepository;
import com.example.serverspring.repository.CardRepository;
import com.example.serverspring.repository.ContactingADoctorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class CardServiceTest {

    @Autowired
    CardService cardService;
    @MockBean
    CardAnswerRepository cardAnswerRepository;
    @MockBean
    ContactingADoctorRepository contactingADoctorRepository;
    @MockBean
    CardRepository cardRepository;

    @Test
    void findAllByPatientId() {
        Patient patient = new Patient(1, "Кислицын", "Иван",
                "Александрович", "kislitsun-van@mail.ru", "vadevid",
                "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8",
                LocalDate.parse("2002-02-03"), "М");
        Doctor doctor = new Doctor(1, "Винилов", "Андрей",
                "Александрович", "doctor1",
                "771d940635373649631e01e04fb257097e8f22a8118a51891fd606b979748ae5", "Терапевт");
        List<Card> list = new ArrayList<>();
        list.add(Card.builder().id(5).name("Общее состояние").patient(patient).doctor(doctor).type("TextField").build());
        Mockito.doReturn(list).when(cardRepository).findAllByPatientId(1);
        Assertions.assertEquals(cardService.findAllByPatientId(1).size(), 1);
    }

    @Test
    void findAllByDoctorId() {
        Patient patient = new Patient(1, "Кислицын", "Иван",
                "Александрович", "kislitsun-van@mail.ru", "vadevid",
                "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8",
                LocalDate.parse("2002-02-03"), "М");
        Doctor doctor = new Doctor(1, "Винилов", "Андрей",
                "Александрович", "doctor1",
                "771d940635373649631e01e04fb257097e8f22a8118a51891fd606b979748ae5", "Терапевт");
        List<Card> list = new ArrayList<>();
        list.add(Card.builder().id(5).name("Общее состояние").patient(patient).doctor(doctor).type("TextField").build());
        Mockito.doReturn(list).when(cardRepository).findAllByDoctorId(1);
        Assertions.assertEquals(cardService.findAllByDoctorId(1).size(), 1);
    }

    @Test
    void getById() {
        Patient patient = new Patient(1, "Кислицын", "Иван",
                "Александрович", "kislitsun-van@mail.ru", "vadevid",
                "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8",
                LocalDate.parse("2002-02-03"), "М");
        Doctor doctor = new Doctor(1, "Винилов", "Андрей",
                "Александрович", "doctor1",
                "771d940635373649631e01e04fb257097e8f22a8118a51891fd606b979748ae5", "Терапевт");
        Card card = Card.builder().id(5).name("Общее состояние").patient(patient).doctor(doctor).type("TextField").build();
        Mockito.doReturn(card).when(cardRepository).getById(5);
        Assertions.assertEquals(cardService.getById(5).getName(), "Общее состояние");
    }

    @Test
    void getAllAnswer() {
        List<CardAnswer> cardAnswers = new ArrayList<>();
        Card card = new Card(7, "Частота дыхательных движений", new Patient(), new Doctor(), "NumberField", 10.0, 30.0);
        cardAnswers.add(new CardAnswer(card, "15"));
        Mockito.doReturn(cardAnswers).when(cardAnswerRepository).findAllByCardIdOrderByAnswerDate(card.getId());
        Assertions.assertEquals(1, cardService.getAllAnswer(card.getId()).size());
    }

    @Test
    void newvalue() {
        Assertions.assertTrue(cardService.newValue(new NewCardAnswerModel(2, "45")));
    }

    @Test
    void save() {
        ContactingADoctor contactingADoctor = new ContactingADoctor(4, "На ноге покраснение", new Doctor(), new Patient());
        Mockito.doReturn(contactingADoctor).when(contactingADoctorRepository).getById(4);
        Assertions.assertTrue(cardService.save(new NewCardModel("Опишите состояние ноги", contactingADoctor.getId(), "TextField")));
    }
}