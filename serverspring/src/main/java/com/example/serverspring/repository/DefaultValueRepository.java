package com.example.serverspring.repository;

import com.example.serverspring.entity.DefaultValue;
import com.example.serverspring.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultValueRepository extends JpaRepository<DefaultValue, Integer> {
    DefaultValue getByPatientOrderById(Patient patient);
    DefaultValue findFirstByPatientOrderByIdDesc(Patient patient);
}