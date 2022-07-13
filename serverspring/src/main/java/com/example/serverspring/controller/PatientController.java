package com.example.serverspring.controller;

import com.example.serverspring.entity.Patient;
import com.example.serverspring.entity.UserToken;
import com.example.serverspring.exception.TokenException;
import com.example.serverspring.models.ContactingADoctorModel;
import com.example.serverspring.models.DefaultValueModel;
import com.example.serverspring.models.PatientInfoModel;
import com.example.serverspring.repository.ContactingADoctorRepository;
import com.example.serverspring.repository.PatientRepository;
import com.example.serverspring.repository.TokenRepository;
import com.example.serverspring.service.AuthenticationService;
import com.example.serverspring.service.ContactingADoctorService;
import com.example.serverspring.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientService patientService;

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    ContactingADoctorRepository contactingADoctorRepository;

    @Autowired
    ContactingADoctorService contactingADoctorService;

    @Autowired
    AuthenticationService authenticationService;


    @PostMapping(path = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public PatientInfoModel PatientIfo(@RequestHeader(required = false, value = "Authorization")String token, @RequestBody @Validated Patient patient) throws TokenException {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.decodeTokenDate(token));
            if (userToken.equals(token) && l > new Date().getTime()) {
                return patientService.patientInfo(patient);
            }
        }
        throw new TokenException();
    }

    @PostMapping(path = "/setvalue", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean SetValue(@RequestHeader(required = false, value = "Authorization")String token, @RequestBody @Validated DefaultValueModel defaultValue) {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.decodeTokenDate(token));
            if (userToken.equals(token) && l > new Date().getTime()) {
                return patientService.setDefaultValue(defaultValue);
            }
        }
        return false;
    }
    @PostMapping(path = "/sendmessage", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean SendMessage(@RequestHeader(required = false, value = "Authorization")String token, @RequestBody @Validated ContactingADoctorModel contactingADoctorModel) {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.decodeTokenDate(token));
            if (userToken.equals(token) && l > new Date().getTime()) {
                contactingADoctorService.save(contactingADoctorModel);
                return true;
            }
        }
        return false;
    }
}
