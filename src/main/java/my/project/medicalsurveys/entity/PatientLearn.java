package my.project.medicalsurveys.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "patient_learn")
public class PatientLearn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "patient_id", insertable = false, updatable = false, nullable = false)
    private long patientId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;

    @Column(name = "learn_module_id", insertable = false, updatable = false, nullable = false)
    private long learnModuleId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "learn_module_id", referencedColumnName = "id", nullable = false)
    private LearnModule learnModule;

    @Column(name = "active", columnDefinition = "boolean default true")
    private boolean active;

    public PatientLearn() {
    }

    public PatientLearn(Long id, long patientId, Patient patient, long learnModuleId, LearnModule learnModule, boolean active) {
        this.id = id;
        this.patientId = patientId;
        this.patient = patient;
        this.learnModuleId = learnModuleId;
        this.learnModule = learnModule;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public long getLearnModuleId() {
        return learnModuleId;
    }

    public void setLearnModuleId(long learnModuleId) {
        this.learnModuleId = learnModuleId;
    }

    public LearnModule getLearnModule() {
        return learnModule;
    }

    public void setLearnModule(LearnModule learnModule) {
        this.learnModule = learnModule;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
