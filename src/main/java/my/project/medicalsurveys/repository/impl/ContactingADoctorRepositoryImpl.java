package my.project.medicalsurveys.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import my.project.medicalsurveys.entity.ContactingADoctor;
import my.project.medicalsurveys.entity.ContactingADoctor_;
import my.project.medicalsurveys.entity.Patient_;
import my.project.medicalsurveys.model.response.MessageModel;
import my.project.medicalsurveys.repository.ContactingADoctorRepository;
import my.project.medicalsurveys.repository.specification.ContactingADoctorSpec;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<MessageModel> findByDoctorId(Long id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<MessageModel> query = builder.createQuery(MessageModel.class);
        Root<ContactingADoctor> root = query.from(ContactingADoctor.class);

        query.multiselect(
                root.get(ContactingADoctor_.id),
                root.get(ContactingADoctor_.text),
                root.get(ContactingADoctor_.patient).get(Patient_.user)
        );

        query.where(ContactingADoctorSpec.byDoctorId(id).toPredicate(root, query, builder));

        return manager.createQuery(query).getResultList();
    }
}
