package my.project.medicalsurveys.model.response;

public class PatientModulesModel {
    private long id;
    private String title;
    private boolean active;

    public PatientModulesModel() {
    }

    public PatientModulesModel(long id, String title, boolean active) {
        this.id = id;
        this.title = title;
        this.active = active;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
