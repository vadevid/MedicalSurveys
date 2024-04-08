package my.project.medicalsurveys.model.request;

public class ContactingADoctorModel {
    private Long patientId;
    private Long doctorId;
    private String message;

    public ContactingADoctorModel() {
    }

    public ContactingADoctorModel(Long patientId, Long doctorId, String message) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.message = message;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
