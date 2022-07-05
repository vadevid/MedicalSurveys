package com.example.serverspring.service;

import com.example.serverspring.entity.ContactingADoctor;
import com.example.serverspring.models.ContactingADoctorModel;
import com.example.serverspring.models.MessageModel;
import com.example.serverspring.repository.ContactingADoctorRepository;
import com.example.serverspring.repository.DoctorRepository;
import com.example.serverspring.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactingADoctorService {
    @Autowired
    ContactingADoctorRepository contactingADoctorRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;

    public boolean save(ContactingADoctorModel contactingADoctorModel) {
        ContactingADoctor contactingADoctor = new ContactingADoctor(patientRepository.getById(contactingADoctorModel.getPatientId()),
                doctorRepository.getById(contactingADoctorModel.getDoctorId()), contactingADoctorModel.getMessage());
        contactingADoctorRepository.save(contactingADoctor);
        return true;
    }
    public MessageModel getMessage(ContactingADoctor contactingADoctor) {
        MessageModel messageModel = new MessageModel(contactingADoctor.getId(), contactingADoctor.getPatient().getFIO(), contactingADoctor.getText());
        return messageModel;
    }
}
