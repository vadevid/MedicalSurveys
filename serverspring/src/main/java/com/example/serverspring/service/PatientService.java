package com.example.serverspring.service;

import com.example.serverspring.entity.DefaultValue;
import com.example.serverspring.entity.Patient;
import com.example.serverspring.models.DefaultValueModel;
import com.example.serverspring.models.PatientInfoModel;
import com.example.serverspring.repository.DefaultValueRepository;
import com.example.serverspring.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DefaultValueRepository defaultValueRepository;

    public PatientInfoModel patientInfo(Patient patient) {
        try {
            Patient tmp = patientRepository.getById(patient.getId());
            DefaultValue defaultValue = defaultValueRepository.findFirstByPatientOrderByIdDesc(tmp);
            PatientInfoModel patientInfo = PatientInfoModel.builder().fio(tmp.getFIO())
                    .age(tmp.getAge().toString()).sex(tmp.getSex())
                    .growth(String.valueOf(defaultValue.getGrowth()))
                    .weight(String.valueOf(defaultValue.getWeight()))
                    .mass_index(String.valueOf(defaultValue.getMassIndex())).build();
            return patientInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean setDefaultValue(DefaultValueModel defaultValueModel) {
        try {
            DefaultValue newDefaultValue = new DefaultValue(patientRepository.getById(defaultValueModel.getPatientId()),
                    Double.parseDouble(defaultValueModel.getGrowth()), Double.parseDouble(defaultValueModel.getWeight()));
            defaultValueRepository.save(newDefaultValue);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Patient findByLogin(String login) {
        return patientRepository.findByLogin(login);
    }
}
