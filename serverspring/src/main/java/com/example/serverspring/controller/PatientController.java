package com.example.serverspring.controller;

import com.example.serverspring.entity.Patient;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public PatientInfoModel PatientIfo( @RequestBody @Validated Patient patient) {
        return patientService.patientinfo(patient);
    }

    @PostMapping(path = "/setvalue", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean SetValue(@RequestBody @Validated DefaultValueModel defaultValue) {
        return patientService.setdefaultvalue(defaultValue);
    }
    @PostMapping(path = "/sendmessage", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean SendMessage(@RequestBody @Validated ContactingADoctorModel contactingADoctorModel) {
        return contactingADoctorService.save(contactingADoctorModel);
    }
}
