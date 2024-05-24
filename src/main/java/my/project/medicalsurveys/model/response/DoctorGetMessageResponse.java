package my.project.medicalsurveys.model.response;

public class DoctorGetMessageResponse {
    private Integer id;
    private String patientName;
    private String text;

    public DoctorGetMessageResponse() {
    }

    public DoctorGetMessageResponse(Integer id, String patientName, String text) {
        this.id = id;
        this.patientName = patientName;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
