package my.project.medicalsurveys.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import my.project.medicalsurveys.entity.*;
import my.project.medicalsurveys.model.response.GetCardResponse;
import my.project.medicalsurveys.model.response.DoctorGetAllCardResponse;
import my.project.medicalsurveys.model.response.PatientGetAllCardResponse;
import my.project.medicalsurveys.repository.CardRepository;
import my.project.medicalsurveys.repository.specification.CardSpec;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CardRepositoryImpl implements CardRepository {

    private final EntityManager manager;

    public CardRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    @Transactional
    public void save(Card card) {
        manager.persist(card);
    }

    @Override
    public List<PatientGetAllCardResponse> findByPatientId(long id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<PatientGetAllCardResponse> query = builder.createQuery(PatientGetAllCardResponse.class);
        Root<Card> root = query.from(Card.class);
        Join<Card, Doctor> doctor = root.join(Card_.doctor);
        Join<Doctor, User> doctorUser = doctor.join(Doctor_.user);

        Selection<String> fullName = builder.concat(
                builder.concat(
                        doctorUser.get(User_.secondName), " "
                ),
                builder.concat(
                        builder.concat(doctorUser.get(User_.firstName), " "),
                        doctorUser.get(User_.middleName)
                )
        );

        query.multiselect(
                root.get(Card_.id),
                root.get(Card_.name),
                fullName,
                doctor.get(Doctor_.type),
                root.get(Card_.type),
                root.get(Card_.newCard)
        );

        query.where(CardSpec.byPatientId(id).toPredicate(root, query, builder));

        query.orderBy(builder.asc(root.get(Card_.id)));

        return manager.createQuery(query).getResultList();
    }

    @Override
    public List<DoctorGetAllCardResponse> findByDoctorId(Long id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<DoctorGetAllCardResponse> query = builder.createQuery(DoctorGetAllCardResponse.class);
        Root<Card> root = query.from(Card.class);
        Join<Card, Patient> patient = root.join(Card_.patient);
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
                root.get(Card_.id),
                root.get(Card_.name),
                fullName,
                root.get(Card_.type)
        );

        query.where(CardSpec.byDoctorId(id).toPredicate(root, query, builder));

        return manager.createQuery(query).getResultList();
    }

    @Override
    public GetCardResponse findInfoById(Integer id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<GetCardResponse> query = builder.createQuery(GetCardResponse.class);
        Root<Card> root = query.from(Card.class);

        query.multiselect(
                root.get(Card_.id),
                root.get(Card_.name),
                root.get(Card_.doctor),
                root.get(Card_.patient),
                root.get(Card_.type)
        );

        query.where(CardSpec.byId(id).toPredicate(root, query, builder));

        return manager.createQuery(query).getSingleResult();
    }

    @Override
    public Card findById(Integer cardId) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Card> query = builder.createQuery(Card.class);
        Root<Card> root = query.from(Card.class);

        query.select(root);

        query.where(CardSpec.byId(cardId).toPredicate(root, query, builder));

        return manager.createQuery(query).getSingleResult();
    }

    @Override
    public List<Card> findNewByPatientId(Long id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Card> query = builder.createQuery(Card.class);
        Root<Card> root = query.from(Card.class);

        query.select(root);

        query.where(CardSpec.byPatientIdAndNew(id).toPredicate(root, query, builder));

        return manager.createQuery(query).getResultList();
    }

    @Override
    @Transactional
    public void update(Card card) {
        manager.merge(card);
    }
}
