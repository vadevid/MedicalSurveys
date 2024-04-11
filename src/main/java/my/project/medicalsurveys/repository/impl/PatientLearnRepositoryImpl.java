package my.project.medicalsurveys.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import my.project.medicalsurveys.entity.PatientLearn;
import my.project.medicalsurveys.repository.PatientLearnRepository;
import my.project.medicalsurveys.repository.specification.PatientLearnSpec;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientLearnRepositoryImpl implements PatientLearnRepository {

    private final EntityManager manager;

    public PatientLearnRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void checkPatientLearn(long patientId, long learnId) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaUpdate<PatientLearn> update = builder.createCriteriaUpdate(PatientLearn.class);

    }

    @Override
    public PatientLearn findByPatientIdAndLearnId(long patientId, long learnId) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<PatientLearn> query = builder.createQuery(PatientLearn.class);
        Root<PatientLearn> root = query.from(PatientLearn.class);

        query.select(root);
        query.where(PatientLearnSpec.byPatientIdAndLearnId(patientId, learnId).toPredicate(root, query, builder));

        List<PatientLearn> result = manager.createQuery(query).getResultList();
        if (result.isEmpty())
            return null;
        return result.get(0);
    }

    @Override
    @Transactional
    public PatientLearn update(PatientLearn patientLearn) {
        return manager.merge(patientLearn);
    }
}
