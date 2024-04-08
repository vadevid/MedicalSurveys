package my.project.medicalsurveys.repository.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import my.project.medicalsurveys.entity.Card;
import my.project.medicalsurveys.entity.Card_;
import org.springframework.data.jpa.domain.Specification;

public class CardSpec {
    public static Specification<Card> byPatientId(long id) {
        return new Specification<Card>() {
            @Override
            public Predicate toPredicate(Root<Card> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Card_.patientId), id);
            }
        };
    }

    public static Specification<Card> byDoctorId(Long id) {
        return new Specification<Card>() {
            @Override
            public Predicate toPredicate(Root<Card> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Card_.doctorId), id);
            }
        };
    }
}
