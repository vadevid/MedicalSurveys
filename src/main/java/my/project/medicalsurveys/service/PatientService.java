package my.project.medicalsurveys.service;


import my.project.medicalsurveys.entity.Card;
import my.project.medicalsurveys.entity.DefaultValue;
import my.project.medicalsurveys.entity.Message;
import my.project.medicalsurveys.entity.Patient;
import my.project.medicalsurveys.model.request.SetValueRequest;
import my.project.medicalsurveys.model.response.PatientGetAllMessageResponse;
import my.project.medicalsurveys.model.response.GetMessageResponse;
import my.project.medicalsurveys.model.response.PatientInfoResponse;
import my.project.medicalsurveys.repository.CardRepository;
import my.project.medicalsurveys.repository.DefaultValueRepository;
import my.project.medicalsurveys.repository.MessageRepository;
import my.project.medicalsurveys.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DefaultValueRepository defaultValueRepository;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    CardRepository cardRepository;

    public PatientInfoResponse getPatientInfo(Long id) throws Exception {
        try {
            Patient patient = patientRepository.findById(id);
            DefaultValue defaultValue = defaultValueRepository.findLast(patient);
            PatientInfoResponse patientInfo = new PatientInfoResponse();
            patientInfo.setFio(patient.getUser().getFIO());
            patientInfo.setAge(patient.getAge());
            patientInfo.setSex(patient.getSex());
            patientInfo.setGrowth(defaultValue != null ? defaultValue.getGrowth() : 0);
            patientInfo.setWeight(defaultValue != null ? defaultValue.getWeight() : 0);
            patientInfo.setMassIndex(defaultValue != null ? Math.floor(defaultValue.getMassIndex()) : 0);
            return patientInfo;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

//    public List<PatientModulesModel> getModules(long id) throws Exception {
//        try {
//            return patientRepository.findModules(id);
//        } catch (Exception ex) {
//            throw new Exception(ex.getMessage());
//        }
//    }

    public boolean setValue(SetValueRequest setValueRequest) throws Exception {
        try {
            DefaultValue defaultValue = new DefaultValue();
            defaultValue.setPatient(patientRepository.findById(setValueRequest.getPatientId()));
            defaultValue.setGrowth(setValueRequest.getGrowth());
            defaultValue.setWeight(setValueRequest.getWeight());
            defaultValueRepository.save(defaultValue);
            return true;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public List<PatientGetAllMessageResponse> getAllMessage(Long id) throws Exception {
        try {
            return messageRepository.getAllByPatientId(id);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public GetMessageResponse getMessage(Integer id) throws Exception {
        try {
            Message message = messageRepository.getById(id);
            message.setChanged(false);
            messageRepository.save(message);
            return messageRepository.getModelById(id);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Boolean deleteMessage(Integer id) throws Exception {
        try {
            messageRepository.delete(id);
            return true;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Boolean checkNewCard(Long id) throws Exception {
        try {
            List<Card> newCards = cardRepository.findNewByPatientId(id);
            return newCards != null && !newCards.isEmpty();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Boolean checkNewMessage(Long id) throws Exception {
        try {
            List<Message> newMessages = messageRepository.findNewByPatientId(id);
            return newMessages != null && !newMessages.isEmpty();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
