package my.project.medicalsurveys.repository;

import my.project.medicalsurveys.entity.Card;
import my.project.medicalsurveys.model.response.GetCardResponse;
import my.project.medicalsurveys.model.response.DoctorGetAllCardResponse;
import my.project.medicalsurveys.model.response.PatientGetAllCardResponse;

import java.util.List;

public interface CardRepository {
    void save(Card card);
    List<PatientGetAllCardResponse> findByPatientId(long id);

    List<DoctorGetAllCardResponse> findByDoctorId(Long id);

    GetCardResponse findInfoById(Integer id);

    Card findById(Integer cardId);

    List<Card> findNewByPatientId(Long id);

    void update(Card card);
}
