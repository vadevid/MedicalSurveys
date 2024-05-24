package my.project.medicalsurveys.service;

import my.project.medicalsurveys.entity.ContactingADoctor;
import my.project.medicalsurveys.entity.Doctor;
import my.project.medicalsurveys.entity.Message;
import my.project.medicalsurveys.entity.Patient;
import my.project.medicalsurveys.model.request.PatientSendMessageRequest;
import my.project.medicalsurveys.model.request.DoctorSendMessageRequest;
import my.project.medicalsurveys.model.response.DoctorGetAllMessageResponse;
import my.project.medicalsurveys.model.response.DoctorGetMessageResponse;
import my.project.medicalsurveys.repository.ContactingADoctorRepository;
import my.project.medicalsurveys.repository.DoctorRepository;
import my.project.medicalsurveys.repository.MessageRepository;
import my.project.medicalsurveys.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactingADoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    ContactingADoctorRepository contactingADoctorRepository;

    @Autowired
    MessageRepository messageRepository;

    public Boolean save(PatientSendMessageRequest patientSendMessageRequest) {
        ContactingADoctor contactingADoctor = new ContactingADoctor();
        Doctor doctor = doctorRepository.findById(patientSendMessageRequest.getDoctorId());
        contactingADoctor.setDoctor(doctor);
        Patient patient = patientRepository.findById(patientSendMessageRequest.getPatientId());
        contactingADoctor.setPatient(patient);
        contactingADoctor.setText(patientSendMessageRequest.getMessage());
        contactingADoctorRepository.save(contactingADoctor);
        return true;
    }

    public List<DoctorGetAllMessageResponse> findByDoctorId(Long id) throws Exception {
        try {
            return contactingADoctorRepository.findByDoctorId(id);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Boolean sendMessage(DoctorSendMessageRequest messageModel) throws Exception {
        try {
            ContactingADoctor contactingADoctor = contactingADoctorRepository.findById(messageModel.getContactingId());
            Message message = new Message();
            message.setDoctor(contactingADoctor.getDoctor());
            message.setPatient(contactingADoctor.getPatient());
            message.setChanged(true);
            message.setText(messageModel.getMessage());
            messageRepository.save(message);
            contactingADoctorRepository.delete(contactingADoctor);
            return true;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public DoctorGetMessageResponse getMessageById(Integer id) throws Exception {
        try {
            return contactingADoctorRepository.getMessageById(id);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
