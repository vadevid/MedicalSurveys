package my.project.medicalsurveys.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import my.project.medicalsurveys.entity.*;
import my.project.medicalsurveys.model.response.PatientModulesModel;
import my.project.medicalsurveys.repository.PatientRepository;
import my.project.medicalsurveys.repository.specification.PatientLearnSpec;
import my.project.medicalsurveys.repository.specification.PatientSpec;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
    public Patient findById(Long id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Patient> query = builder.createQuery(Patient.class);
        Root<Patient> root = query.from(Patient.class);

        query.select(root);
        query.where(PatientSpec.byId(id).toPredicate(root, query, builder));

        List<Patient> result = manager.createQuery(query).getResultList();
        if (result.isEmpty()) return null;
        return result.get(0);
    }

    @Override
    public List<PatientModulesModel> findModules(long id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<PatientModulesModel> query = builder.createQuery(PatientModulesModel.class);
        Root<PatientLearn> root = query.from(PatientLearn.class);
        Join<PatientLearn, LearnModule> learnModule = root.join(PatientLearn_.learnModule);

        query.multiselect(
                learnModule.get(LearnModule_.id),
                learnModule.get(LearnModule_.title),
                root.get(PatientLearn_.active)
        );

        query.where(PatientLearnSpec.byPatientId(id).toPredicate(root, query, builder));
        query.orderBy(builder.asc(root.get(PatientLearn_.id)));
        return manager.createQuery(query).getResultList();
    }
}
