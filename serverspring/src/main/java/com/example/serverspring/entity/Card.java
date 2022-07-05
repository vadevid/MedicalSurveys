package com.example.serverspring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(name = "type", nullable = false, length = 50)
    private String type;

    @Column(name = "min_value")
    private Double minValue;

    @Column(name = "max_value")
    private Double maxValue;

    public Card(Integer id, String name, Patient patient, Doctor doctor, String type, Double minValue, Double maxValue) {
        this.id = id;
        this.name = name;
        this.patient = patient;
        this.doctor = doctor;
        this.type = type;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public Card(String name, Patient patient, Doctor doctor, String type, Double minValue, Double maxValue) {
        this.name = name;
        this.patient = patient;
        this.doctor = doctor;
        this.type = type;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public Card(){};
}