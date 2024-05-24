package my.project.medicalsurveys.model.request;

public class NewCardValueRequest {
    private Integer cardId;
    private String value;

    public NewCardValueRequest() {
    }

    public NewCardValueRequest(Integer cardId, String value) {
        this.cardId = cardId;
        this.value = value;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
