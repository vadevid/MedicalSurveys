package com.example.serverspring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "doctor")
public class Doctor {
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

    @Column(name = "login", nullable = false, length = 50)
    private String login;

    @Column(name = "password", length = 64)
    private String password;

    @Column(name = "type", nullable = false, length = 50)
    private String type;

    public Doctor(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Doctor() {
    }

    public Doctor(Integer id, String secondName, String firstName, String middleName, String login, String password, String type) {
        this.id = id;
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.login = login;
        this.password = password;
        this.type = type;
    }

    public String getFIO() {
        return (secondName + " " + firstName + " " + middleName);
    }
}