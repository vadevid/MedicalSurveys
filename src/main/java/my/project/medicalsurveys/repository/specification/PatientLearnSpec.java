package my.project.medicalsurveys.repository.specification;

import jakarta.persistence.criteria.*;
import my.project.medicalsurveys.entity.Patient;
import my.project.medicalsurveys.entity.PatientLearn;
import my.project.medicalsurveys.entity.PatientLearn_;
import my.project.medicalsurveys.entity.Patient_;
import org.springframework.data.jpa.domain.Specification;

public class PatientLearnSpec {

    public static Specification<PatientLearn> byPatientId(long id) {
        return new Specification<PatientLearn>() {
            @Override
            public Predicate toPredicate(Root<PatientLearn> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Join<PatientLearn, Patient> patient = root.join(PatientLearn_.patient);
                return criteriaBuilder.equal(patient.get(Patient_.id), id);
            }
        };
    }

    public static Specification<PatientLearn> byPatientIdAndLearnId(long patientId, long learnId) {
        return new Specification<PatientLearn>() {
            @Override
            public Predicate toPredicate(Root<PatientLearn> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.and(
                        criteriaBuilder.equal(root.get(PatientLearn_.patientId), patientId),
                        criteriaBuilder.equal(root.get(PatientLearn_.learnModuleId), learnId)
                );
            }
        };
    }
}
