package com.example.serverspring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "default_value")
public class DefaultValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(name = "growth")
    private Double growth;

    @Column(name = "weight")
    private Double weight;

    public DefaultValue(Patient patient, double growth, double weight) {
        this.patient = patient;
        this.growth = growth;
        this.weight = weight;
    }
    public DefaultValue() {}

    public double getMassIndex() {
        return (this.weight / (this.growth/100 * this.growth/100));
    }
}