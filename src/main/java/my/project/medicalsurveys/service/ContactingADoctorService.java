package my.project.medicalsurveys.service;

import my.project.medicalsurveys.entity.ContactingADoctor;
import my.project.medicalsurveys.entity.Doctor;
import my.project.medicalsurveys.entity.Patient;
import my.project.medicalsurveys.model.request.ContactingADoctorModel;
import my.project.medicalsurveys.repository.ContactingADoctorRepository;
import my.project.medicalsurveys.repository.DoctorRepository;
import my.project.medicalsurveys.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactingADoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    ContactingADoctorRepository contactingADoctorRepository;

    public Boolean save(ContactingADoctorModel contactingADoctorModel) {
        ContactingADoctor contactingADoctor = new ContactingADoctor();
        Doctor doctor = doctorRepository.findById(contactingADoctorModel.getDoctorId());
        contactingADoctor.setDoctor(doctor);
        Patient patient = patientRepository.findById(contactingADoctorModel.getPatientId());
        contactingADoctor.setPatient(patient);
        contactingADoctor.setText(contactingADoctorModel.getMessage());
        contactingADoctorRepository.save(contactingADoctor);
        return true;
    }
}
