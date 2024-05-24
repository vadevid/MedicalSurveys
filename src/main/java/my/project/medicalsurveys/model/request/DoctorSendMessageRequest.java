package my.project.medicalsurveys.model.request;

public class DoctorSendMessageRequest {
    private Integer contactingId;
    private String message;

    public DoctorSendMessageRequest() {
    }

    public DoctorSendMessageRequest(Integer contactingId, String message) {
        this.contactingId = contactingId;
        this.message = message;
    }

    public Integer getContactingId() {
        return contactingId;
    }

    public void setContactingId(Integer contactingId) {
        this.contactingId = contactingId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
