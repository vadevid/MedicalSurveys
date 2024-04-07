package my.project.medicalsurveys.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;
    @Column(name = "sex", nullable = false, length = 1)
    private String sex;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public Patient() {
    }

    public Patient(Long id, String email, LocalDate birthdate, String sex, User user) {
        this.id = id;
        this.email = email;
        this.birthdate = birthdate;
        this.sex = sex;
        this.user = user;
    }

    public Integer getAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}