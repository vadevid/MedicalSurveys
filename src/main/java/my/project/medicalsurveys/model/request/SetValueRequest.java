package my.project.medicalsurveys.model.request;

public class SetValueRequest {
    private Long patientId;
    private Double growth;
    private Double weight;

    public SetValueRequest() {
    }


    public SetValueRequest(Long patientId, Double growth, Double weight) {
        this.patientId = patientId;
        this.growth = growth;
        this.weight = weight;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
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
}
