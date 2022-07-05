package com.example.serverspring.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewCardModel {
    String name;
    Integer contactingId;
    Double min;
    Double max;
    String type;

    public NewCardModel(String name, Integer contactingId, Double min, Double max, String type) {
        this.name = name;
        this.contactingId = contactingId;
        this.min = min;
        this.max = max;
        this.type = type;
    }

    public NewCardModel(String name, Integer contactingId, String type) {
        this.name = name;
        this.contactingId = contactingId;
        this.type = type;
    }

    public NewCardModel(){}
}
