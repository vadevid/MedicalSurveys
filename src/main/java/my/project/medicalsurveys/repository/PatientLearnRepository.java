package my.project.medicalsurveys.repository;

import my.project.medicalsurveys.entity.PatientLearn;

public interface PatientLearnRepository {

    void checkPatientLearn(long patientId, long learnId);

    PatientLearn findByPatientIdAndLearnId(long patientId, long learnId);

    void update(PatientLearn patientLearn);
}
