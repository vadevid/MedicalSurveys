package com.example.models;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class PatientInfoModel {

    private String fio;
    private String age;
    private String sex;
    private String growth;
    private String weight;
    private String mass_index;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }


    public PatientInfoModel(String fio, String age, String sex, String growth, String weight, String mass_index) {
        this.fio = fio;
        this.age = age;
        this.sex = sex;
        this.growth = growth;
        this.weight = weight;
        this.mass_index = mass_index;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getMass_index() {
        return mass_index;
    }

    public void setMass_index(String mass_index) {
        this.mass_index = mass_index;
    }
}
