package my.project.medicalsurveys.model.request;

public class CheckLearnModel {
    private long patientId;
    private long learnId;

    public CheckLearnModel() {
    }

    public CheckLearnModel(long patientId, long learnId) {
        this.patientId = patientId;
        this.learnId = learnId;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getLearnId() {
        return learnId;
    }

    public void setLearnId(long learnId) {
        this.learnId = learnId;
    }
}
