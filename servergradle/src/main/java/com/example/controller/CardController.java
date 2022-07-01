package com.example.controller;

import com.example.entity.Card;
import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.entity.UserToken;
import com.example.models.*;
import com.example.repository.CardRepository;
import com.example.repository.DoctorRepository;
import com.example.repository.TokenRepository;
import com.example.service.AuthenticationService;
import com.example.service.CardService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

import static io.micronaut.http.HttpHeaders.AUTHORIZATION;

@Controller("/card")
@Secured(SecurityRule.IS_ANONYMOUS)
public class CardController {
    @Inject
    CardRepository cardRepository;
    @Inject
    DoctorRepository doctorRepository;
    @Inject
    CardService cardService;
    @Inject
    TokenRepository tokenRepository;
    @Inject
    AuthenticationService authenticationService;

    @Post(value = "/getall", consumes = MediaType.APPLICATION_JSON)
    public List<CardModel> findAllByPatientId(@Header(AUTHORIZATION)String token, @Body @Valid Patient patient) {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.DecodeTokenDate(token));
            if (userToken.equals(token) || l > new Date().getTime()) {
                return cardService.findAllByPatientId(patient.getId());
            }
        }
        return null;
    }
    @Post(value = "/getdoctorall", consumes = MediaType.APPLICATION_JSON)
    public List<DoctorCardModel> findAllByDoctorId(@Header(AUTHORIZATION)String token, @Body @Valid Doctor doctor) {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.DecodeTokenDate(token));
            if (userToken.equals(token) || l > new Date().getTime()) {
                return cardService.findAllByDoctorId(doctor.getId());
            }
        }
        return null;
    }
    @Post(value = "/getcard", consumes = MediaType.APPLICATION_JSON)
    public CardInfoModel getById(@Header(AUTHORIZATION)String token, @Body @Valid Card card) {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.DecodeTokenDate(token));
            if (userToken.equals(token) || l > new Date().getTime()) {
                return cardService.getById(card.getId());
            }
        }
        return null;
    }

    @Post(value = "/getallanswer", consumes = MediaType.APPLICATION_JSON)
    public List<CardAnswerModel> getAllAnswer(@Header(AUTHORIZATION)String token, @Body Card card) {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.DecodeTokenDate(token));
            if (userToken.equals(token) || l > new Date().getTime()) {
                return cardService.getAllAnswer(card.getId());
            }
        }
        return null;
    }

    @Post(value = "/newvalue", consumes = MediaType.APPLICATION_JSON)
    public boolean newValue(@Header(AUTHORIZATION)String token, @Body @Valid NewCardAnswerModel newCardAnswerModel) {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.DecodeTokenDate(token));
            if (userToken.equals(token) || l > new Date().getTime()) {
                return cardService.newvalue(newCardAnswerModel);
            }
        }
        return false;
    }
}
