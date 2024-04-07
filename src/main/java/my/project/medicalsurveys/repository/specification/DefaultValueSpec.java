package my.project.medicalsurveys.repository.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import my.project.medicalsurveys.entity.DefaultValue;
import my.project.medicalsurveys.entity.DefaultValue_;
import my.project.medicalsurveys.entity.Patient;
import org.springframework.data.jpa.domain.Specification;

public class DefaultValueSpec {

    public static Specification<DefaultValue> byPatient(Patient patient) {
        return new Specification<DefaultValue>() {
            @Override
            public Predicate toPredicate(Root<DefaultValue> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(DefaultValue_.patient), patient);
            }
        };

    }
}
