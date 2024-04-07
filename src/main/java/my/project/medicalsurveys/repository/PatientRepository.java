package my.project.medicalsurveys.repository;


import my.project.medicalsurveys.entity.Patient;

public interface PatientRepository {
    void save(Patient patient);
    Patient getById(Long id);
}
