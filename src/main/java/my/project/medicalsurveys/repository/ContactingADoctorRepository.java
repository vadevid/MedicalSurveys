package my.project.medicalsurveys.repository;

import my.project.medicalsurveys.entity.ContactingADoctor;
import my.project.medicalsurveys.model.response.MessageModel;

import java.util.List;

public interface ContactingADoctorRepository {
    void save(ContactingADoctor contactingADoctor);

    List<MessageModel> findByDoctorId(Long id);
}
