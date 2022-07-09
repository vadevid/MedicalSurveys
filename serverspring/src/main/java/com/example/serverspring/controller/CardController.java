package com.example.serverspring.controller;

import com.example.serverspring.entity.Card;
import com.example.serverspring.entity.Doctor;
import com.example.serverspring.entity.Patient;
import com.example.serverspring.models.*;
import com.example.serverspring.repository.TokenRepository;
import com.example.serverspring.service.AuthenticationService;
import com.example.serverspring.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;
    @Autowired
    TokenRepository tokenRepository;
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CardModel> findAllByPatientId(@RequestBody @Validated Patient patient) {
        return cardService.findAllByPatientId(patient.getId());
    }
    @PostMapping(path= "/getdoctorall", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DoctorCardModel> findAllByDoctorId(@RequestBody @Validated Doctor doctor) {
        return cardService.findAllByDoctorId(doctor.getId());
    }
    @PostMapping(path= "/getcard", produces = MediaType.APPLICATION_JSON_VALUE)
    public CardInfoModel getById(@RequestBody @Validated Card card) {
        return cardService.getById(card.getId());
    }

    @PostMapping(path= "/getallanswer", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CardAnswerModel> getAllAnswer(@RequestBody @Validated Card card) {
        return cardService.getAllAnswer(card.getId());
    }

    @PostMapping(path= "/newvalue", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean newValue(@RequestBody @Validated NewCardAnswerModel newCardAnswerModel) {
        return cardService.newvalue(newCardAnswerModel);
    }
}
