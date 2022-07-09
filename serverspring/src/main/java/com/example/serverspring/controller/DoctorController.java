package com.example.serverspring.controller;

import com.example.serverspring.entity.ContactingADoctor;
import com.example.serverspring.entity.Doctor;
import com.example.serverspring.entity.UserToken;
import com.example.serverspring.models.AnswerCardModel;
import com.example.serverspring.models.MessageModel;
import com.example.serverspring.models.NewCardModel;
import com.example.serverspring.repository.ContactingADoctorRepository;
import com.example.serverspring.repository.DoctorRepository;
import com.example.serverspring.repository.TokenRepository;
import com.example.serverspring.service.AuthenticationService;
import com.example.serverspring.service.CardService;
import com.example.serverspring.service.ContactingADoctorService;
import com.example.serverspring.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    ContactingADoctorService contactingADoctorService;
    @Autowired
    ContactingADoctorRepository contactingADoctorRepository;
    @Autowired
    TokenRepository tokenRepository;
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    CardService cardService;

    @PostMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Doctor> getAll(@RequestHeader(required = false, value = "Authorization")String token) {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.DecodeTokenDate(token));
            if (userToken.equals(token) || l > new Date().getTime()) {
                return doctorRepository.findAll();
            }
        }
        return null;
    }
    @PostMapping(path = "/getallmessage", produces = MediaType.APPLICATION_JSON_VALUE)
    List<AnswerCardModel> getAllMessage(@RequestBody @Validated Doctor doctor) {
        return doctorService.getAllMessage(doctor.getId());
    }
    @PostMapping(path = "/getmessage", produces = MediaType.APPLICATION_JSON_VALUE)
    MessageModel getMessage(@RequestBody @Validated ContactingADoctor contactingADoctor) {
        return contactingADoctorService.getMessage(contactingADoctorRepository.getById(contactingADoctor.getId()));
    }

    @PostMapping(path = "/sendcard", produces = MediaType.APPLICATION_JSON_VALUE)
    boolean SendCard(@RequestBody @Validated NewCardModel newCardModel) {
        return cardService.save(newCardModel);
    }
}
