package my.project.medicalsurveys.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import my.project.medicalsurveys.entity.ContactingADoctor;
import my.project.medicalsurveys.repository.ContactingADoctorRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ContactingADoctorRepositoryImpl implements ContactingADoctorRepository {
    private final EntityManager manager;

    public ContactingADoctorRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    @Transactional
    public void save(ContactingADoctor contactingADoctor) {
        manager.persist(contactingADoctor);
    }
}
