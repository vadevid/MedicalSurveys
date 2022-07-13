package com.example.serverspring.service;

import com.example.serverspring.entity.ContactingADoctor;
import com.example.serverspring.entity.Doctor;
import com.example.serverspring.entity.Patient;
import com.example.serverspring.models.AnswerCardModel;
import com.example.serverspring.repository.ContactingADoctorRepository;
import com.example.serverspring.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    ContactingADoctorRepository contactingADoctorRepository;
    @Autowired
    DoctorRepository doctorRepository;

    public List<AnswerCardModel> getAllMessage(Integer id){
        List<ContactingADoctor> contactingADoctors = contactingADoctorRepository.findAllByDoctorId(id);
        List<AnswerCardModel> answerCardModels = new ArrayList<>();
        contactingADoctors.forEach((ContactingADoctor contactingADoctor) -> answerCardModels.add(new AnswerCardModel(contactingADoctor.getId(),
                contactingADoctor.getText(), contactingADoctor.getPatient().getFIO())));
        return answerCardModels;
    }
    public Doctor findByLogin(String login) {
        return doctorRepository.getByLogin(login);
    }
}
