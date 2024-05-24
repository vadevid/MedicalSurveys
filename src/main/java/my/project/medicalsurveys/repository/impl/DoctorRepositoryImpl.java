package my.project.medicalsurveys.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import my.project.medicalsurveys.entity.*;
import my.project.medicalsurveys.model.response.FindAllDoctorResponse;
import my.project.medicalsurveys.repository.DoctorRepository;
import my.project.medicalsurveys.repository.specification.DoctorSpec;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DoctorRepositoryImpl implements DoctorRepository {
    private final EntityManager manager;

    public DoctorRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    @Transactional
    public void save(Doctor doctor) {
        manager.persist(doctor);
    }

    @Override
    public Doctor findById(Long id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Doctor> query = builder.createQuery(Doctor.class);
        Root<Doctor> root = query.from(Doctor.class);

        query.select(root);
        query.where(DoctorSpec.byDoctorId(id).toPredicate(root, query, builder));

        List<Doctor> result = manager.createQuery(query).getResultList();
        if (result.isEmpty()) return null;
        return result.get(0);
    }

    @Override
    public List<FindAllDoctorResponse> findAll() {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<FindAllDoctorResponse> query = builder.createQuery(FindAllDoctorResponse.class);
        Root<Doctor> root = query.from(Doctor.class);
        Join<Doctor, User> doctorUser = root.join(Doctor_.user);

        query.multiselect(
                root.get(Doctor_.id),
                root.get(Doctor_.type),
                doctorUser.get(User_.secondName),
                doctorUser.get(User_.firstName),
                doctorUser.get(User_.middleName));

        return manager.createQuery(query).getResultList();
    }
}
