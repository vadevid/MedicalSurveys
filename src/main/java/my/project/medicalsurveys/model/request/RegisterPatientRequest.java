package my.project.medicalsurveys.model.request;

public class RegisterPatientRequest {
    private String secondName;
    private String firstName;
    private String middleName;
    private String login;
    private String password;
    private String email;
    private String birthdate;
    private String sex;

    public RegisterPatientRequest() {
    }

    public RegisterPatientRequest(String secondName, String firstName, String middleName, String login, String password, String email, String  birthdate, String sex) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
        this.sex = sex;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String  getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String  birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
