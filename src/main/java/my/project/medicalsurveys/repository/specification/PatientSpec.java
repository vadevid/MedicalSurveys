package my.project.medicalsurveys.repository.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import my.project.medicalsurveys.entity.Patient;
import my.project.medicalsurveys.entity.Patient_;
import org.springframework.data.jpa.domain.Specification;

public class PatientSpec {

    public static Specification<Patient> byId(Long id) {
        return new Specification<Patient>() {
            @Override
            public Predicate toPredicate(Root<Patient> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Patient_.id), id);
            }
        };
    }
}
