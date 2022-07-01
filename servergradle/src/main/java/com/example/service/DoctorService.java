package com.example.service;

import com.example.entity.CardAnswer;
import com.example.entity.ContactingADoctor;
import com.example.models.AnswerCardModel;
import com.example.repository.CardAnswerRepository;
import com.example.repository.ContactingADoctorRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class DoctorService {
    @Inject
    ContactingADoctorRepository contactingADoctorRepository;

    public List<AnswerCardModel> getAllMessage(Integer id){
        List<ContactingADoctor> contactingADoctors = contactingADoctorRepository.findAllByDoctorId(id);
        List<AnswerCardModel> answerCardModels = new ArrayList<>();
        for (ContactingADoctor contactingADoctor: contactingADoctors) {
            answerCardModels.add(new AnswerCardModel(contactingADoctor.getId(), contactingADoctor.getText(), contactingADoctor.getPatient().getFIO()));
        }
        return answerCardModels;
    }
}
