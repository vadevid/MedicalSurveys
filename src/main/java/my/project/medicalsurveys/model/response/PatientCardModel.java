package my.project.medicalsurveys.model.response;

public class    PatientCardModel {

    private Integer id;
    private String name;
    private String doctorName;
    private String doctorType;
    private String cardType;

    public PatientCardModel() {
    }

    public PatientCardModel(Integer id, String name, String doctorName, String doctorType, String cardType) {
        this.id = id;
        this.name = name;
        this.doctorName = doctorName;
        this.doctorType = doctorType;
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

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
