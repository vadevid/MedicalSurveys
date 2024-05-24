package my.project.medicalsurveys.model.response;


import my.project.medicalsurveys.entity.Doctor;
import my.project.medicalsurveys.entity.Patient;

public class GetCardResponse {
    private Integer id;
    private String name;
    private Doctor doctor;
    private Patient patient;
    private String cardType;

    public GetCardResponse() {
    }

    public GetCardResponse(Integer id, String name, Doctor doctor, Patient patient, String cardType) {
        this.id = id;
        this.name = name;
        this.doctor = doctor;
        this.patient = patient;
        this.cardType = cardType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
