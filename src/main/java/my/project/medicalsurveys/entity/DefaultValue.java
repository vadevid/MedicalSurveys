package my.project.medicalsurveys.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "default_value")
public class DefaultValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(name = "growth")
    private Double growth;

    @Column(name = "weight")
    private Double weight;

    public DefaultValue() {}

    public DefaultValue(Integer id, Patient patient, Double growth, Double weight) {
        this.id = id;
        this.patient = patient;
        this.growth = growth;
        this.weight = weight;
    }

    public double getMassIndex() {
        return (this.weight / (this.growth/100 * this.growth/100));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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