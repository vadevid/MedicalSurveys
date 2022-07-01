package com.example.controller;

import com.example.models.ContactingADoctorModel;
import com.example.models.DefaultValueModel;
import com.example.repository.ContactingADoctorRepository;
import com.example.service.AuthenticationService;
import com.example.entity.Patient;
import com.example.entity.UserToken;
import com.example.models.PatientInfoModel;
import com.example.repository.PatientRepository;
import com.example.repository.TokenRepository;
import com.example.service.ContactingADoctorService;
import com.example.service.PatientService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import static io.micronaut.http.HttpHeaders.AUTHORIZATION;

@Controller("/patient")
@Secured(SecurityRule.IS_ANONYMOUS)
public class PatientController {


    @Inject
    PatientRepository patientRepository;

    @Inject
    PatientService patientService;

    @Inject
    TokenRepository tokenRepository;

    @Inject
    ContactingADoctorRepository contactingADoctorRepository;

    @Inject
    ContactingADoctorService contactingADoctorService;

    @Inject
    AuthenticationService authenticationService;


    @Post(value = "/info", consumes = MediaType.APPLICATION_JSON)
    public PatientInfoModel PatientIfo(@Header(AUTHORIZATION)String token, @Body @Valid Patient patient) {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.DecodeTokenDate(token));
            if (userToken.equals(token) || l > new Date().getTime()) {
                return patientService.patientinfo(patient);
            }
        }
        return null;
    }

    @Post(value = "/setvalue", consumes = MediaType.APPLICATION_JSON)
    public boolean SetValue(@Header(AUTHORIZATION)String token, @Body @Valid DefaultValueModel defaultValue) {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.DecodeTokenDate(token));
            if (userToken.equals(token) || l > new Date().getTime()) {
                return patientService.setdefaultvalue(defaultValue);
            }
        }
        return false;
    }
    @Post(value = "/sendmessage", consumes = MediaType.APPLICATION_JSON)
    public boolean SendMessage(@Header(AUTHORIZATION)String token, @Body @Valid ContactingADoctorModel contactingADoctorModel) {
        for (UserToken ut : tokenRepository.getUsersTokenList()) {
            String userToken = ut.getUserToken();
            Long l = Long.parseLong(authenticationService.DecodeTokenDate(token));
            if (userToken.equals(token) || l > new Date().getTime()) {
                contactingADoctorService.save(contactingADoctorModel);
                return true;
            }
        }
        return false;
    }
}
