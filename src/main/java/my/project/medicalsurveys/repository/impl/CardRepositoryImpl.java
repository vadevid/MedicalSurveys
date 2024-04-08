package my.project.medicalsurveys.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import my.project.medicalsurveys.entity.*;
import my.project.medicalsurveys.model.response.DoctorCardModel;
import my.project.medicalsurveys.model.response.PatientCardModel;
import my.project.medicalsurveys.repository.CardRepository;
import my.project.medicalsurveys.repository.specification.CardSpec;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardRepositoryImpl implements CardRepository {

    private final EntityManager manager;

    public CardRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void save(Card card) {
        manager.persist(card);
    }

    @Override
    public List<PatientCardModel> findByPatientId(long id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<PatientCardModel> query = builder.createQuery(PatientCardModel.class);
        Root<Card> root = query.from(Card.class);
        Join<Card, Doctor> doctor = root.join(Card_.doctor);
        Join<Doctor, User> doctorUser = doctor.join(Doctor_.user);

        query.multiselect(
                root.get(Card_.id),
                root.get(Card_.name),
                doctorUser.get(User_.secondName),
                doctorUser.get(User_.firstName),
                doctorUser.get(User_.middleName),
                doctor.get(Doctor_.type),
                root.get(Card_.type)
        );

        query.where(CardSpec.byPatientId(id).toPredicate(root, query, builder));

        return manager.createQuery(query).getResultList();
    }

    @Override
    public List<DoctorCardModel> findByDoctorId(Long id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<DoctorCardModel> query = builder.createQuery(DoctorCardModel.class);
        Root<Card> root = query.from(Card.class);
        Join<Card, Patient> patient = root.join(Card_.patient);
        Join<Patient, User> patientUser = patient.join(Patient_.user);

        query.multiselect(
                root.get(Card_.id),
                root.get(Card_.name),
                patientUser.get(User_.secondName),
                patientUser.get(User_.firstName),
                patientUser.get(User_.middleName),
                root.get(Card_.type)
        );

        query.where(CardSpec.byDoctorId(id).toPredicate(root, query, builder));

        return manager.createQuery(query).getResultList();
    }
}
