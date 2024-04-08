package my.project.medicalsurveys.model.response;

public class DoctorModel {
    private Long id;
    private String type;
    private String secondName;
    private String firstName;
    private String middleName;

    public DoctorModel() {
    }

    public DoctorModel(Long id, String type, String secondName, String firstName, String middleName) {
        this.id = id;
        this.type = type;
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
