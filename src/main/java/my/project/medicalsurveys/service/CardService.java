package my.project.medicalsurveys.service;

import my.project.medicalsurveys.entity.Card;
import my.project.medicalsurveys.entity.CardAnswer;
import my.project.medicalsurveys.entity.ContactingADoctor;
import my.project.medicalsurveys.model.request.NewCardValueRequest;
import my.project.medicalsurveys.model.request.SendCardRequest;
import my.project.medicalsurveys.model.response.GetCardAllAnswerResponse;
import my.project.medicalsurveys.model.response.GetCardResponse;
import my.project.medicalsurveys.model.response.DoctorGetAllCardResponse;
import my.project.medicalsurveys.model.response.PatientGetAllCardResponse;
import my.project.medicalsurveys.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardAnswerRepository cardAnswerRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ContactingADoctorRepository contactingADoctorRepository;

    public List<PatientGetAllCardResponse> findByPatientId(Long id) throws Exception {
        try {
            return cardRepository.findByPatientId(id);
        } catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public List<DoctorGetAllCardResponse> findByDoctorId(Long id) throws Exception {
        try {
            return cardRepository.findByDoctorId(id);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public GetCardResponse findById(Integer id) throws Exception {
        try {
            Card card = cardRepository.findById(id);
            card.setNewCard(false);
            cardRepository.save(card);
            return cardRepository.findInfoById(id);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Boolean newCardValue(NewCardValueRequest newCardValueRequest) throws Exception {
        try {
            Card card = cardRepository.findById(newCardValueRequest.getCardId());
            card.setChanged(true);
            cardRepository.update(card);
            CardAnswer cardAnswer = new CardAnswer();
            cardAnswer.setCard(cardRepository.findById(newCardValueRequest.getCardId()));
            cardAnswer.setAnswer(newCardValueRequest.getValue());
            cardAnswer.setAnswerDate(LocalDate.now());
            cardAnswerRepository.save(cardAnswer);
            return true;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public List<GetCardAllAnswerResponse> getAllAnswer(Integer id) throws Exception {
        try {
            return cardAnswerRepository.getAllAnswer(id);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Boolean sendCard(SendCardRequest request) throws Exception {
        try {
            ContactingADoctor contactingADoctor = contactingADoctorRepository.findById(request.getContactingId());
            Card card = new Card();
            card.setName(request.getName());
            card.setPatient(contactingADoctor.getPatient());
            card.setDoctor(contactingADoctor.getDoctor());
            card.setType(request.getType());
            card.setMinValue(request.getMin());
            card.setMaxValue(request.getMax());
            card.setChanged(false);
            card.setNewCard(true);
            cardRepository.save(card);
            contactingADoctorRepository.delete(contactingADoctor);
            return true;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
