package my.project.medicalsurveys.service;


import my.project.medicalsurveys.entity.DefaultValue;
import my.project.medicalsurveys.entity.Patient;
import my.project.medicalsurveys.model.response.PatientInfoModel;
import my.project.medicalsurveys.model.response.PatientModulesModel;
import my.project.medicalsurveys.repository.DefaultValueRepository;
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

    public PatientInfoModel getPatientInfo(Long id) throws Exception {
        try {
            Patient patient = patientRepository.findById(id);
            DefaultValue defaultValue = defaultValueRepository.findLast(patient);
            PatientInfoModel patientInfo = new PatientInfoModel();
            patientInfo.setFio(patient.getUser().getFIO());
            patientInfo.setAge(patient.getAge());
            patientInfo.setSex(patient.getSex());
            patientInfo.setGrowth(defaultValue.getGrowth());
            patientInfo.setWeight(defaultValue.getWeight());
            patientInfo.setMassIndex(Math.floor(defaultValue.getMassIndex()));
            return patientInfo;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public List<PatientModulesModel> getModules(long id) throws Exception {
        try {
            return patientRepository.findModules(id);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
