package com.example.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

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

    public Card(Integer id, String name, Patient patient, Doctor doctor, String type) {
        this.id = id;
        this.name = name;
        this.patient = patient;
        this.doctor = doctor;
        this.type = type;
    }

    public Card() {
    }

    public Card(Integer id) {
        this.id = id;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }
}