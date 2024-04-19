package my.project.medicalsurveys.model.response;

import my.project.medicalsurveys.entity.Patient;
import my.project.medicalsurveys.entity.User;

public class MessageModel {
    private Integer id;
    private String answer;
    private String patientName;

    public MessageModel() {
    }

    public MessageModel(Integer id, String answer, User patient) {
        this.id = id;
        this.answer = answer;
        this.patientName = patient.getFIO();
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
