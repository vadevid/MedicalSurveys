package com.example.serverspring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "second_name", nullable = false, length = 50)
    private String secondName;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "middle_name", length = 50)
    private String middleName;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "login", nullable = false, length = 50)
    private String login;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "sex", nullable = false, length = 1)
    private String sex;

    public Patient(String secondName, String firstName, String middleName,
                   String email, String login, String password,
                   LocalDate birthdate, String sex) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.email = email;
        this.login = login;
        this.password = password;
        this.birthdate = birthdate;
        this.sex = sex;
    }

    public Patient () {}

    public Patient(Integer id, String secondName, String firstName, String middleName, String email, String login, String password, LocalDate birthdate, String sex) {
        this.id = id;
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.email = email;
        this.login = login;
        this.password = password;
        this.birthdate = birthdate;
        this.sex = sex;
    }

    public Patient(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Patient(Integer id) {
        this.id = id;
    }

    public String getFIO() {
        return (secondName + " " + firstName + " " + middleName);
    }

    public Integer getAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }
}