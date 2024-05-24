package my.project.medicalsurveys.repository.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import my.project.medicalsurveys.entity.Message;
import my.project.medicalsurveys.entity.Message_;
import my.project.medicalsurveys.entity.Patient_;
import my.project.medicalsurveys.entity.User_;
import org.springframework.data.jpa.domain.Specification;

public class MessageSpec {
    public static Specification<Message> byPatientId(Long id) {
        return new Specification<Message>() {
            @Override
            public Predicate toPredicate(Root<Message> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Message_.patient).get(Patient_.user).get(User_.id), id);
            }
        };
    }

    public static Specification<Message> byId(Integer id) {
        return new Specification<Message>() {
            @Override
            public Predicate toPredicate(Root<Message> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Message_.id), id);
            }
        };
    }

    public static Specification<Message> byNewAndPatientId(Long id) {
        return new Specification<Message>() {
            @Override
            public Predicate toPredicate(Root<Message> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.and(
                        byPatientId(id).toPredicate(root, query, criteriaBuilder),
                        byNew().toPredicate(root, query, criteriaBuilder)
                );
            }
        };
    }

    private static Specification<Message> byNew() {
        return new Specification<Message>() {
            @Override
            public Predicate toPredicate(Root<Message> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.isTrue(root.get(Message_.changed));
            }
        };
    }
}
