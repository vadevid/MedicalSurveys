package my.project.medicalsurveys.repository.impl;

import jakarta.persistence.EntityManager;
import my.project.medicalsurveys.entity.Doctor;
import my.project.medicalsurveys.repository.DoctorRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorRepositoryImpl implements DoctorRepository {
    private final EntityManager manager;

    public DoctorRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void save(Doctor doctor) {
        manager.persist(doctor);
    }
}
