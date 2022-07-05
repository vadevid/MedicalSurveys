package com.example.serverspring.repository;

import com.example.serverspring.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Override
    List<Patient> findAll();
    Patient getByLogin(String login);
    Patient getById(Integer id);
    Patient findByLogin(String login);
}