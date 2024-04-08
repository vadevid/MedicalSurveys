package my.project.medicalsurveys.repository;

import my.project.medicalsurveys.entity.Doctor;
import my.project.medicalsurveys.model.response.DoctorModel;

import java.util.List;

public interface DoctorRepository {
    void save(Doctor doctor);

    Doctor findById(Long doctorId);

    List<DoctorModel> findAll();
}
