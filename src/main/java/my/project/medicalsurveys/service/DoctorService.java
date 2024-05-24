package my.project.medicalsurveys.service;

import my.project.medicalsurveys.model.response.FindAllDoctorResponse;
import my.project.medicalsurveys.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public List<FindAllDoctorResponse> findAll() throws Exception {
        try {
            return doctorRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
