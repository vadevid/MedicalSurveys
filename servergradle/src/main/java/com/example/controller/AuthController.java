package com.example.controller;

import com.example.entity.Doctor;
import com.example.service.AuthenticationService;
import com.example.entity.Patient;
import com.example.models.AnswerModel;
import com.example.models.PatientModel;
import com.example.service.PatientService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

import javax.validation.Valid;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/auth")
public class AuthController {
    @Inject
    private AuthenticationService authenticationService;
    @Inject
    PatientService patientService;

    @Post(value = "/register", consumes = MediaType.APPLICATION_JSON)
    public boolean RegisterPatient(@Body @Valid PatientModel patient) {
        return authenticationService.save(patient);
    }

    @Post(value = "/login", consumes = MediaType.APPLICATION_JSON)
    public AnswerModel LoginPatient(@Body @Valid Patient patient) {
        return authenticationService.login(patient);
    }

    @Post(value = "/logindoctor", consumes = MediaType.APPLICATION_JSON)
    public AnswerModel LoginDoctor(@Body @Valid Doctor doctor) { return authenticationService.loginDoctor(doctor); }
}
