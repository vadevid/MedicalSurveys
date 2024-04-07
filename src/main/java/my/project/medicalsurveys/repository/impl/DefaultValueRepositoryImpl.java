package my.project.medicalsurveys.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import my.project.medicalsurveys.entity.DefaultValue;
import my.project.medicalsurveys.entity.DefaultValue_;
import my.project.medicalsurveys.entity.Patient;
import my.project.medicalsurveys.repository.DefaultValueRepository;
import my.project.medicalsurveys.repository.specification.DefaultValueSpec;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DefaultValueRepositoryImpl implements DefaultValueRepository {

    private final EntityManager manager;

    public DefaultValueRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }
    @Override
    public void save(DefaultValue value) {
        manager.persist(value);
    }

    @Override
    public DefaultValue findLast(Patient patient) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<DefaultValue> query = builder.createQuery(DefaultValue.class);
        Root<DefaultValue> root = query.from(DefaultValue.class);

        query.select(root);
        query.where(DefaultValueSpec.byPatient(patient).toPredicate(root, query, builder));
        query.orderBy(builder.desc(root.get(DefaultValue_.id)));

        List<DefaultValue> result = manager.createQuery(query).getResultList();
        if (result.isEmpty()) return null;
        return result.get(0);
    }
}
