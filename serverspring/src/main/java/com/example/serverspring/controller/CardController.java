package com.example.serverspring.controller;

import com.example.serverspring.entity.Card;
import com.example.serverspring.entity.Doctor;
import com.example.serverspring.entity.Patient;
import com.example.serverspring.entity.UserToken;
import com.example.serverspring.exception.TokenException;
import com.example.serverspring.models.*;
import com.example.serverspring.repository.TokenRepository;
import com.example.serverspring.service.AuthenticationService;
import com.example.serverspring.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;
    @Autowired
    TokenRepository tokenRepository;
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CardModel> findAllByPatientId(@RequestHeader(required = false, value = "Authorization")String token, @RequestBody @Validated Patient patient) throws TokenException {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.decodeTokenDate(token));
            if (userToken.equals(token) && l > new Date().getTime()) {
                return cardService.findAllByPatientId(patient.getId());
            }
        }
        throw new TokenException();
    }
    @PostMapping(path= "/getdoctorall", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DoctorCardModel> findAllByDoctorId(@RequestHeader(required = false, value = "Authorization")String token, @RequestBody @Validated Doctor doctor) throws TokenException {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.decodeTokenDate(token));
            if (userToken.equals(token) && l > new Date().getTime()) {
                return cardService.findAllByDoctorId(doctor.getId());
            }
        }
        throw new TokenException();
    }
    @PostMapping(path= "/getcard", produces = MediaType.APPLICATION_JSON_VALUE)
    public CardInfoModel getById(@RequestHeader(required = false, value = "Authorization")String token, @RequestBody @Validated Card card) throws TokenException {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.decodeTokenDate(token));
            if (userToken.equals(token) && l > new Date().getTime()) {
                return cardService.getById(card.getId());
            }
        }
        throw new TokenException();
    }

    @PostMapping(path= "/getallanswer", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CardAnswerModel> getAllAnswer(@RequestHeader(required = false, value = "Authorization")String token, @RequestBody @Validated Card card) throws TokenException {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.decodeTokenDate(token));
            if (userToken.equals(token) && l > new Date().getTime()) {
                return cardService.getAllAnswer(card.getId());
            }
        }
        throw new TokenException();
    }

    @PostMapping(path= "/newvalue", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean newValue(@RequestHeader(required = false, value = "Authorization")String token, @RequestBody @Validated NewCardAnswerModel newCardAnswerModel) {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.decodeTokenDate(token));
            if (userToken.equals(token) && l > new Date().getTime()) {
                return cardService.newValue(newCardAnswerModel);
            }
        }
        return false;
    }
}
