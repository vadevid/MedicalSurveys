package my.project.medicalsurveys.repository;

import my.project.medicalsurveys.entity.CardAnswer;
import my.project.medicalsurveys.model.response.GetCardAllAnswerResponse;

import java.util.List;

public interface CardAnswerRepository {
    void save(CardAnswer cardAnswer);

    List<GetCardAllAnswerResponse> getAllAnswer(Integer id);
}
