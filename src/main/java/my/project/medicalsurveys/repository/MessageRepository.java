package my.project.medicalsurveys.repository;

import my.project.medicalsurveys.entity.Message;
import my.project.medicalsurveys.model.response.PatientGetAllMessageResponse;
import my.project.medicalsurveys.model.response.GetMessageResponse;

import java.util.List;

public interface MessageRepository {
    void save(Message message);

    List<PatientGetAllMessageResponse> getAllByPatientId(Long id);

    GetMessageResponse getModelById(Integer id);

    void delete(Integer id);

    Message getById(Integer id);

    List<Message> findNewByPatientId(Long id);
}
