package my.project.medicalsurveys.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import my.project.medicalsurveys.entity.*;
import my.project.medicalsurveys.model.response.PatientGetAllMessageResponse;
import my.project.medicalsurveys.model.response.GetMessageResponse;
import my.project.medicalsurveys.repository.MessageRepository;
import my.project.medicalsurveys.repository.specification.MessageSpec;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    private final EntityManager manager;

    public MessageRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }
    @Override
    @Transactional
    public void save(Message message) {
        manager.persist(message);
    }

    @Override
    public List<PatientGetAllMessageResponse> getAllByPatientId(Long id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<PatientGetAllMessageResponse> query = builder.createQuery(PatientGetAllMessageResponse.class);
        Root<Message> root = query.from(Message.class);
        Join<Message, Doctor> doctor = root.join(Message_.doctor);
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
                root.get(Message_.id),
                fullName,
                doctor.get(Doctor_.type),
                root.get(Message_.changed)
        );

        query.where(MessageSpec.byPatientId(id).toPredicate(root, query, builder));

        return manager.createQuery(query).getResultList();
    }

    @Override
    public GetMessageResponse getModelById(Integer id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<GetMessageResponse> query = builder.createQuery(GetMessageResponse.class);
        Root<Message> root = query.from(Message.class);
        Join<Message, Doctor> doctor = root.join(Message_.doctor);
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
                root.get(Message_.id),
                fullName,
                doctor.get(Doctor_.type),
                root.get(Message_.text)
        );

        query.where(MessageSpec.byId(id).toPredicate(root, query, builder));

        return manager.createQuery(query).getSingleResult();
    }

    @Override
    public Message getById(Integer id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Message> query = builder.createQuery(Message.class);
        Root<Message> root = query.from(Message.class);

        query.select(root);

        query.where(MessageSpec.byId(id).toPredicate(root, query, builder));

        return manager.createQuery(query).getSingleResult();
    }

    @Override
    public List<Message> findNewByPatientId(Long id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Message> query = builder.createQuery(Message.class);
        Root<Message> root = query.from(Message.class);

        query.select(root);

        query.where(MessageSpec.byNewAndPatientId(id).toPredicate(root, query, builder));

        return manager.createQuery(query).getResultList();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Message message = getById(id);
        manager.remove(message);
    }
}
