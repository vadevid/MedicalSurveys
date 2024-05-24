package my.project.medicalsurveys.model.request;

public class SendCardRequest {
    private String name;
    private Integer contactingId;
    private Double min;
    private Double max;
    private String type;

    public SendCardRequest() {
    }

    public SendCardRequest(String name, Integer contactingId, Double min, Double max, String type) {
        this.name = name;
        this.contactingId = contactingId;
        this.min = min;
        this.max = max;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getContactingId() {
        return contactingId;
    }

    public void setContactingId(Integer contactingId) {
        this.contactingId = contactingId;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
