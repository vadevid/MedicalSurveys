package my.project.medicalsurveys.repository;


import my.project.medicalsurveys.entity.Patient;

public interface PatientRepository {
    void save(Patient patient);
    Patient findById(Long id);

//    List<PatientModulesModel> findModules(long id);
}
