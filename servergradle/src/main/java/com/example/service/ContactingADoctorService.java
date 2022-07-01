package com.example.service;

import com.example.entity.ContactingADoctor;
import com.example.models.ContactingADoctorModel;
import com.example.models.MessageModel;
import com.example.repository.ContactingADoctorRepository;
import com.example.repository.DoctorRepository;
import com.example.repository.PatientRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class ContactingADoctorService {
    @Inject
    ContactingADoctorRepository contactingADoctorRepository;
    @Inject
    PatientRepository patientRepository;
    @Inject
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
