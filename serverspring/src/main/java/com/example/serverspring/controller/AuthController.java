package com.example.serverspring.controller;

import com.example.serverspring.entity.Doctor;
import com.example.serverspring.entity.Patient;
import com.example.serverspring.models.AnswerModel;
import com.example.serverspring.models.PatientModel;
import com.example.serverspring.repository.PatientRepository;
import com.example.serverspring.security.jwt.JwtTokenProvider;
import com.example.serverspring.service.AuthenticationService;
import com.example.serverspring.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    PatientService patientService;

    @Autowired
    PatientRepository patientRepository;

    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    @PostMapping(path= "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean RegisterPatient(@RequestBody @Validated PatientModel patient) {
        return authenticationService.save(patient);
    }

    @PostMapping(path= "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public AnswerModel LoginPatient(@RequestBody @Validated Patient patient) {
        String login = patient.getLogin();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, patient.getPassword()));
        Patient patient1 = patientService.findByLogin(login);

        if (patient1 == null) {
            return new AnswerModel("2");
        }

        String token = jwtTokenProvider.createToken(login);

        return new AnswerModel("0", patient1.getId().toString(), token);
    }

    @PostMapping(path= "/logindoctor", produces = MediaType.APPLICATION_JSON_VALUE)
    public AnswerModel LoginDoctor(@RequestBody @Validated Doctor doctor) { return authenticationService.loginDoctor(doctor); }

    @PostMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Patient> getAll() { return patientRepository.findAll(); }
}
