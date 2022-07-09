package com.example.serverspring.service;

import com.example.serverspring.entity.DefaultValue;
import com.example.serverspring.entity.Doctor;
import com.example.serverspring.entity.Patient;
import com.example.serverspring.entity.UserToken;
import com.example.serverspring.models.AnswerModel;
import com.example.serverspring.models.PatientModel;
import com.example.serverspring.repository.DefaultValueRepository;
import com.example.serverspring.repository.DoctorRepository;
import com.example.serverspring.repository.PatientRepository;
import com.example.serverspring.repository.TokenRepository;
import com.google.common.hash.Hashing;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class AuthenticationService {

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    public void main() {

    }
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    DefaultValueRepository defaultValueRepository;

    public boolean save(PatientModel patient) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            Patient repoPatient = new Patient(patient.getSecondName(), patient.getFirstName(), patient.getMiddleName(),
                    patient.getEmail(), patient.getLogin(), Hashing.sha256().hashString(patient.getPassword(), StandardCharsets.UTF_8).toString(),
                    LocalDate.parse(patient.getBirthdate(), formatter),patient.getSex());
            DefaultValue defaultValue = new DefaultValue(repoPatient, 0, 0);
            patientRepository.save(repoPatient);
            defaultValueRepository.save(defaultValue);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public AnswerModel login(Patient patient) {
        String token = "";
        Map<String, Object> tokenData = new HashMap<>();
        try {
            Patient tmp = patientRepository.getByLogin(patient.getLogin());
            if (tmp.getPassword().equals(Hashing.sha256().hashString(patient.getPassword(), StandardCharsets.UTF_8).toString())) {
                tokenData.put("clientType", "user");
                tokenData.put("userID", tmp.getId());
                tokenData.put("username", tmp.getFIO());
                tokenData.put("token_create_date", new Date().getTime());
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.YEAR, 100);
                tokenData.put("token_expiration_date", calendar.getTime());
                JwtBuilder jwtBuilder = Jwts.builder();
                jwtBuilder.setExpiration(calendar.getTime());
                jwtBuilder.setClaims(tokenData);
                String key = "abc123";
                token = jwtBuilder.signWith(SignatureAlgorithm.HS512, key).compact();
                tokenRepository.getUsersTokenList().add(new UserToken(tmp.getLogin(), "Bearer " + token));

                return new AnswerModel("0", tmp.getId().toString(), token);

            } else return new AnswerModel("1");
        } catch (Exception e) {
            return new AnswerModel("2");
        }
    }
    public AnswerModel loginDoctor(Doctor doctor) {
        try {
            Doctor tmp = doctorRepository.getByLogin(doctor.getLogin());
            if (tmp.getPassword().equals(Hashing.sha256().hashString(doctor.getPassword(), StandardCharsets.UTF_8).toString())) {
                return new AnswerModel("0", tmp.getId().toString());

            } else return new AnswerModel("1");
        } catch (Exception e) {
            return new AnswerModel("2");
        }
    }

    public String DecodeTokenDate(String token) {
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();

        String payload = new String(decoder.decode(chunks[1]));
        String[] payloadData = payload.split(",");
        String[] date = payloadData[1].split(":");
        return date[1];
    }

    private String encodeB64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private byte[] decodeB64(String data) {
        return Base64.getDecoder().decode(data);
    }
}
