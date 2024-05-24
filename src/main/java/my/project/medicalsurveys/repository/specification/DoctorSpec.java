package my.project.medicalsurveys.repository.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import my.project.medicalsurveys.entity.Doctor;
import my.project.medicalsurveys.entity.Doctor_;
import my.project.medicalsurveys.entity.User_;
import org.springframework.data.jpa.domain.Specification;

public class DoctorSpec {
    public static Specification<Doctor> byId(Long id) {
        return new Specification<Doctor>() {
            @Override
            public Predicate toPredicate(Root<Doctor> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Doctor_.user).get(User_.id), id);
            }
        };
    }

    public static Specification<Doctor> byDoctorId(Long id) {
        return new Specification<Doctor>() {
            @Override
            public Predicate toPredicate(Root<Doctor> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Doctor_.id), id);
            }
        };
    }
}
