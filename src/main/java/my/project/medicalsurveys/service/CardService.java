package my.project.medicalsurveys.service;

import my.project.medicalsurveys.model.response.DoctorCardModel;
import my.project.medicalsurveys.model.response.PatientCardModel;
import my.project.medicalsurveys.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public List<PatientCardModel> findByPatientId(Long id) throws Exception {
        try {
            return cardRepository.findByPatientId(id);
        } catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public List<DoctorCardModel> findByDoctorId(Long id) throws Exception {
        try {
            return cardRepository.findByDoctorId(id);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
