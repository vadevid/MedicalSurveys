package com.example.serverspring.security;

import com.example.serverspring.entity.Patient;
import com.example.serverspring.security.jwt.JwtPatient;
import com.example.serverspring.security.jwt.JwtPatientFactory;
import com.example.serverspring.service.AuthenticationService;
import com.example.serverspring.service.DoctorService;
import com.example.serverspring.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtPatientDetailsService implements UserDetailsService {

    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    PatientService patientService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Patient patient = patientService.findByLogin(login);

        if (patient == null) {
            throw new UsernameNotFoundException("Patient with login: " + login + " not found");
        }
        JwtPatient jwtPatient = JwtPatientFactory.create(patient);

        return null;
    }
}
