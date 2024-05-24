package my.project.medicalsurveys.repository.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import my.project.medicalsurveys.entity.ContactingADoctor;
import my.project.medicalsurveys.entity.ContactingADoctor_;
import my.project.medicalsurveys.entity.Doctor_;
import my.project.medicalsurveys.entity.User_;
import org.springframework.data.jpa.domain.Specification;

public class ContactingADoctorSpec {
    public static Specification<ContactingADoctor> byDoctorId(Long id) {
        return new Specification<ContactingADoctor>() {
            @Override
            public Predicate toPredicate(Root<ContactingADoctor> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(ContactingADoctor_.doctor).get(Doctor_.user).get(User_.id), id);
            }
        };
    }

    public static Specification<ContactingADoctor> byId(Integer contactingId) {
        return new Specification<ContactingADoctor>() {
            @Override
            public Predicate toPredicate(Root<ContactingADoctor> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(ContactingADoctor_.id), contactingId);
            }
        };
    }
}
