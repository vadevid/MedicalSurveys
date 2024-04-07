package my.project.medicalsurveys.model.request;

public class RegisterDoctorRequest {
    private String secondName;
    private String firstName;
    private String middleName;
    private String login;
    private String password;
    private String type;

    public RegisterDoctorRequest() {
    }

    public RegisterDoctorRequest(String secondName, String firstName, String middleName, String login, String password, String type) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.login = login;
        this.password = password;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
