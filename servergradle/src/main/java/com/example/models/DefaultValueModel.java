package com.example.models;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class DefaultValueModel {
    Integer patientId;
    String growth;
    String weight;

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getGrowth() {
        return growth;
    }

    public void setGrowth(String growth) {
        this.growth = growth;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public DefaultValueModel(Integer patientId, String growth, String weight) {
        this.patientId = patientId;
        this.growth = growth;
        this.weight = weight;
    }
}
