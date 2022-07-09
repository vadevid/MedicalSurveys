package com.example.serverspring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "contacting_a_doctor")
public class ContactingADoctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "text", nullable = false, length = 150)
    private String text;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    public ContactingADoctor(Patient patient, Doctor doctor, String text) {
        this.patient = patient;
        this.doctor = doctor;
        this.text = text;
    }

    public ContactingADoctor() {
    }

    public ContactingADoctor(Integer id) {
        this.id = id;
    }

    public ContactingADoctor(Integer id, String text, Doctor doctor, Patient patient) {
        this.id = id;
        this.text = text;
        this.doctor = doctor;
        this.patient = patient;
    }
}