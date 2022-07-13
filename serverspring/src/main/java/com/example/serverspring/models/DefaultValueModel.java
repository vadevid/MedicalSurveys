package com.example.serverspring.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class DefaultValueModel {
    Integer patientId;
    String growth;
    String weight;

    public DefaultValueModel(Integer patientId, String growth, String weight) {
        this.patientId = patientId;
        this.growth = growth;
        this.weight = weight;
    }
}
