package com.example.controller;

import com.example.entity.ContactingADoctor;
import com.example.entity.Doctor;
import com.example.entity.UserToken;
import com.example.models.AnswerCardModel;
import com.example.models.MessageModel;
import com.example.models.NewCardModel;
import com.example.repository.ContactingADoctorRepository;
import com.example.repository.DoctorRepository;
import com.example.repository.TokenRepository;
import com.example.service.AuthenticationService;
import com.example.service.CardService;
import com.example.service.ContactingADoctorService;
import com.example.service.DoctorService;
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

@Controller("/doctor")
@Secured(SecurityRule.IS_ANONYMOUS)
public class DoctorController {
    @Inject
    DoctorRepository doctorRepository;
    @Inject
    ContactingADoctorService contactingADoctorService;
    @Inject
    ContactingADoctorRepository contactingADoctorRepository;
    @Inject
    TokenRepository tokenRepository;
    @Inject
    AuthenticationService authenticationService;
    @Inject
    DoctorService doctorService;
    @Inject
    CardService cardService;

    @Post(value = "/getall", consumes = MediaType.APPLICATION_JSON)
    List<Doctor> getAll(@Header(AUTHORIZATION)String token) {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.DecodeTokenDate(token));
            if (userToken.equals(token) || l > new Date().getTime()) {
                return doctorRepository.findAll();
            }
        }
        return null;
    }
    @Post(value = "/getallmessage", consumes = MediaType.APPLICATION_JSON)
    List<AnswerCardModel> getAllMessage(@Header(AUTHORIZATION)String token, @Body @Valid Doctor doctor) {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.DecodeTokenDate(token));
            if (userToken.equals(token) || l > new Date().getTime()) {
                return doctorService.getAllMessage(doctor.getId());
            }
        }
        return null;
    }
    @Post(value = "/getmessage", consumes = MediaType.APPLICATION_JSON)
    MessageModel getMessage(@Header(AUTHORIZATION)String token, @Body @Valid ContactingADoctor contactingADoctor) {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.DecodeTokenDate(token));
            if (userToken.equals(token) || l > new Date().getTime()) {
                return contactingADoctorService.getMessage(contactingADoctorRepository.getById(contactingADoctor.getId()));
            }
        }
        return null;
    }

    @Post(value = "/sendcard", consumes = MediaType.APPLICATION_JSON)
    boolean SendCard(@Header(AUTHORIZATION)String token, @Body @Valid NewCardModel newCardModel) {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.DecodeTokenDate(token));
            if (userToken.equals(token) || l > new Date().getTime()) {
                return cardService.save(newCardModel);
            }
        }
        return false;
    }
}

