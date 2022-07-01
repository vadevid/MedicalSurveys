package com.example.models;

public class AnswerCardModel {
    Integer id;
    String answer;
    String patientName;

    public AnswerCardModel(Integer id, String answer, String patientName) {
        this.id = id;
        this.answer = answer;
        this.patientName = patientName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
