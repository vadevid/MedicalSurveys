package com.example.serverspring.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PatientModel {
    private String secondName;
    private String firstName;
    private String middleName;
    private String login;
    private String password;
    private String birthdate;
    private String email;
    private String sex;

    public PatientModel(String secondName, String firstName,
                        String middleName, String login, String password,
                        String birthdate, String email, String sex) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.login = login;
        this.password = password;
        this.birthdate = birthdate;
        this.email = email;
        this.sex = sex;
    }

    public PatientModel() {
    }
}
