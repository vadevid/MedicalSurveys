package my.project.medicalsurveys.repository;

import my.project.medicalsurveys.entity.ContactingADoctor;
import my.project.medicalsurveys.model.response.DoctorGetAllMessageResponse;
import my.project.medicalsurveys.model.response.DoctorGetMessageResponse;

import java.util.List;

public interface ContactingADoctorRepository {
    void save(ContactingADoctor contactingADoctor);

    List<DoctorGetAllMessageResponse> findByDoctorId(Long id);

    ContactingADoctor findById(Integer contactingId);

    DoctorGetMessageResponse getMessageById(Integer id);

    void delete(ContactingADoctor contactingADoctor);
}
