package my.project.medicalsurveys.repository.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import my.project.medicalsurveys.entity.*;
import org.springframework.data.jpa.domain.Specification;

public class CardSpec {
    public static Specification<Card> byPatientId(long id) {
        return new Specification<Card>() {
            @Override
            public Predicate toPredicate(Root<Card> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Card_.patient).get(Patient_.user).get(User_.id), id);
            }
        };
    }

    public static Specification<Card> byDoctorId(Long id) {
        return new Specification<Card>() {
            @Override
            public Predicate toPredicate(Root<Card> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Card_.doctor).get(Doctor_.user).get(User_.id), id);
            }
        };
    }

    public static Specification<Card> byId(Integer id) {
        return new Specification<Card>() {
            @Override
            public Predicate toPredicate(Root<Card> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Card_.id), id);
            }
        };
    }

    public static Specification<Card> byPatientIdAndNew(Long id) {
        return new Specification<Card>() {
            @Override
            public Predicate toPredicate(Root<Card> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.and(
                        byPatientId(id).toPredicate(root, query, criteriaBuilder),
                        byNew().toPredicate(root, query, criteriaBuilder)
                );
            }
        };
    }

    public static Specification<Card> byNew() {
        return new Specification<Card>() {
            @Override
            public Predicate toPredicate(Root<Card> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.isTrue(root.get(Card_.newCard));
            }
        };
    }
}
