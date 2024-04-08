package my.project.medicalsurveys.repository;

import my.project.medicalsurveys.entity.Card;
import my.project.medicalsurveys.model.response.DoctorCardModel;
import my.project.medicalsurveys.model.response.PatientCardModel;

import java.util.List;

public interface CardRepository {
    void save(Card card);
    List<PatientCardModel> findByPatientId(long id);

    List<DoctorCardModel> findByDoctorId(Long id);
}
