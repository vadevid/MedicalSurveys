package my.project.medicalsurveys.model.response;

public class PatientGetAllMessageResponse {
    private Integer id;
    private String doctorName;
    private String doctorType;
    private boolean newMessage;

    public PatientGetAllMessageResponse() {
    }

    public PatientGetAllMessageResponse(Integer id, String doctorName, String doctorType, boolean newMessage) {
        this.id = id;
        this.doctorName = doctorName;
        this.doctorType = doctorType;
        this.newMessage = newMessage;
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

    public boolean getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(boolean newMessage) {
        this.newMessage = newMessage;
    }
}
