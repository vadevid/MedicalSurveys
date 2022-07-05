package com.example.serverspring.security;

import com.example.serverspring.entity.Doctor;
import com.example.serverspring.service.AuthenticationService;
import com.example.serverspring.service.DoctorService;
import com.example.serverspring.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtDoctorDetailsService implements UserDetailsService {
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    DoctorService doctorService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Doctor doctor = doctorService.findByLogin(login);
        return null;
    }
}
