package com.example.repository;

import com.example.entity.Patient;
import com.example.models.PatientInfoModel;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {
    @Override
    List<Patient> findAll();
    Patient getByLogin(String login);
    Patient getById(Integer id);
}
