package my.project.medicalsurveys.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import my.project.medicalsurveys.entity.*;
import my.project.medicalsurveys.model.response.DoctorGetAllMessageResponse;
import my.project.medicalsurveys.model.response.DoctorGetMessageResponse;
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
    public List<DoctorGetAllMessageResponse> findByDoctorId(Long id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<DoctorGetAllMessageResponse> query = builder.createQuery(DoctorGetAllMessageResponse.class);
        Root<ContactingADoctor> root = query.from(ContactingADoctor.class);

        query.multiselect(
                root.get(ContactingADoctor_.id),
                root.get(ContactingADoctor_.text),
                root.get(ContactingADoctor_.patient).get(Patient_.user)
        );

        query.where(ContactingADoctorSpec.byDoctorId(id).toPredicate(root, query, builder));

        return manager.createQuery(query).getResultList();
    }

    @Override
    public ContactingADoctor findById(Integer contactingId) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ContactingADoctor> query = builder.createQuery(ContactingADoctor.class);
        Root<ContactingADoctor> root = query.from(ContactingADoctor.class);

        query.select(root);

        query.where(ContactingADoctorSpec.byId(contactingId).toPredicate(root, query, builder));

        return manager.createQuery(query).getSingleResult();
    }

    @Override
    public DoctorGetMessageResponse getMessageById(Integer id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<DoctorGetMessageResponse> query = builder.createQuery(DoctorGetMessageResponse.class);
        Root<ContactingADoctor> root = query.from(ContactingADoctor.class);
        Join<ContactingADoctor, Patient> patient = root.join(ContactingADoctor_.patient);
        Join<Patient, User> patientUser = patient.join(Patient_.user);

        Selection<String> fullName = builder.concat(
                builder.concat(
                        patientUser.get(User_.secondName), " "
                ),
                builder.concat(
                        builder.concat(patientUser.get(User_.firstName), " "),
                        patientUser.get(User_.middleName)
                )
        );

        query.multiselect(
                root.get(ContactingADoctor_.id),
                fullName,
                root.get(ContactingADoctor_.text)
        );

        query.where(ContactingADoctorSpec.byId(id).toPredicate(root, query, builder));

        return manager.createQuery(query).getSingleResult();
    }

    @Override
    @Transactional
    public void delete(ContactingADoctor contactingADoctor) {
        manager.remove(contactingADoctor);
    }
}
