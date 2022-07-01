package com.example.service;

import com.example.entity.DefaultValue;
import com.example.entity.Patient;
import com.example.models.DefaultValueModel;
import com.example.models.PatientInfoModel;
import com.example.models.PatientModel;
import com.example.repository.DefaultValueRepository;
import com.example.repository.PatientRepository;
import com.google.common.hash.Hashing;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Singleton
public class PatientService {

    @Inject
    PatientRepository patientRepository;
    @Inject
    DefaultValueRepository defaultValueRepository;

    public PatientInfoModel patientinfo(Patient patient) {
        try {
            Patient tmp = patientRepository.getById(patient.getId());
            DefaultValue defaultValue = defaultValueRepository.findFirstByPatientOrderByIdDesc(tmp);
            PatientInfoModel patientInfo = new PatientInfoModel(tmp.getFIO(),
                    tmp.getAge().toString(), tmp.getSex(), String.valueOf(defaultValue.getGrowth()),
                    String.valueOf(defaultValue.getWeight()), String.valueOf(defaultValue.getMassIndex()));
            return patientInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean setdefaultvalue(DefaultValueModel defaultValueModel) {
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
}
