package my.project.medicalsurveys.repository;

import my.project.medicalsurveys.entity.DefaultValue;
import my.project.medicalsurveys.entity.Patient;

public interface DefaultValueRepository {
    void save(DefaultValue value);
    DefaultValue findLast(Patient patient);
}
