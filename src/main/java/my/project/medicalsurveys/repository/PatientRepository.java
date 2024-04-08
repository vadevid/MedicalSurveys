package my.project.medicalsurveys.repository;


import my.project.medicalsurveys.entity.Patient;
import my.project.medicalsurveys.model.response.PatientModulesModel;

import java.util.List;

public interface PatientRepository {
    void save(Patient patient);
    Patient findById(Long id);

    List<PatientModulesModel> findModules(long id);
}
