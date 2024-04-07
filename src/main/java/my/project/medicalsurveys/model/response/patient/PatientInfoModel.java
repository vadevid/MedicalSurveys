package my.project.medicalsurveys.model.response.patient;

public class PatientInfoModel {
    private String fio;
    private Integer age;
    private String sex;
    private Double growth;
    private Double weight;
    private Double massIndex;

    public PatientInfoModel() {
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getGrowth() {
        return growth;
    }

    public void setGrowth(Double growth) {
        this.growth = growth;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getMassIndex() {
        return massIndex;
    }

    public void setMassIndex(Double massIndex) {
        this.massIndex = massIndex;
    }
}
