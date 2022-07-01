package com.example.repository;

import com.example.entity.Doctor;
import com.example.entity.Patient;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
    Doctor getById(Integer id);
    @Override
    List<Doctor> findAll();
    Doctor getByLogin(String login);
}
