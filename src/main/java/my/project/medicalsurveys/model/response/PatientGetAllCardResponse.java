package my.project.medicalsurveys.model.response;

public class PatientGetAllCardResponse {

    private Integer id;
    private String name;
    private String doctorName;
    private String doctorType;
    private String cardType;
    private boolean newCard;

    public PatientGetAllCardResponse() {
    }

    public PatientGetAllCardResponse(Integer id, String name, String doctorName, String doctorType, String cardType, boolean newCard) {
        this.id = id;
        this.name = name;
        this.doctorName = doctorName;
        this.doctorType = doctorType;
        this.cardType = cardType;
        this.newCard = newCard;
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

    public boolean isNewCard() {
        return newCard;
    }

    public void setNewCard(boolean newCard) {
        this.newCard = newCard;
    }
}
