package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "default_value")
public class DefaultValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    public DefaultValue() {
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(name = "growth")
    private double growth;

    @Column(name = "weight")
    private double weight;

    public DefaultValue(Patient patient, double growth, double weight) {
        this.patient = patient;
        this.growth = growth;
        this.weight = weight;
    }

    public double getMassIndex() {
        return (this.weight / (this.growth/100 * this.growth/100));
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public double getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}