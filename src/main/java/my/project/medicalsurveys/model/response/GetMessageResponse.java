package my.project.medicalsurveys.model.response;

public class GetMessageResponse {
    private Integer id;
    private String doctorName;
    private String doctorType;
    private String text;

    public GetMessageResponse() {
    }

    public GetMessageResponse(Integer id, String doctorName, String doctorType, String text) {
        this.id = id;
        this.doctorName = doctorName;
        this.doctorType = doctorType;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
