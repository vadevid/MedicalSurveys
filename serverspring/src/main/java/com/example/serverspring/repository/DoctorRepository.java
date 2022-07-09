package com.example.serverspring.repository;

import com.example.serverspring.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor getByLogin(String login);
    Doctor getById(Integer id);
}