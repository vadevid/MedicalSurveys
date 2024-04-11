package my.project.medicalsurveys.service;

import my.project.medicalsurveys.entity.PatientLearn;
import my.project.medicalsurveys.repository.PatientLearnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientLearnService {

    @Autowired
    PatientLearnRepository patientLearnRepository;

    public void checkPatientLearn(long patientId, long learnId) {
        PatientLearn patientLearn = patientLearnRepository.findByPatientIdAndLearnId(patientId, learnId);
        patientLearn.setActive(false);
        patientLearnRepository.update(patientLearn);
    }
}
