package com.example.serverspring.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientInfoModel {

    private String fio;
    private String age;
    private String sex;
    private String growth;
    private String weight;
    private String mass_index;

    public PatientInfoModel(String fio, String age, String sex, String growth, String weight, String mass_index) {
        this.fio = fio;
        this.age = age;
        this.sex = sex;
        this.growth = growth;
        this.weight = weight;
        this.mass_index = mass_index;
    }
}
