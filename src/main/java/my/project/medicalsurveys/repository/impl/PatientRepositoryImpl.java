package my.project.medicalsurveys.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import my.project.medicalsurveys.entity.Patient;
import my.project.medicalsurveys.repository.PatientRepository;
import my.project.medicalsurveys.repository.specification.PatientSpec;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepositoryImpl implements PatientRepository {

    private final EntityManager manager;

    public PatientRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void save(Patient patient) {
        manager.persist(patient);
    }

    @Override
    public Patient getById(Long id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Patient> query = builder.createQuery(Patient.class);
        Root<Patient> root = query.from(Patient.class);

        query.select(root);
        query.where(PatientSpec.byId(id).toPredicate(root, query, builder));

        List<Patient> result = manager.createQuery(query).getResultList();
        if (result.isEmpty()) return null;
        return result.get(0);
    }
}
