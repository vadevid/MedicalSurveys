package com.example.serverspring.repository;

import com.example.serverspring.entity.ContactingADoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactingADoctorRepository extends JpaRepository<ContactingADoctor, Integer> {
    List<ContactingADoctor> findAllByDoctorId(Integer id);
    ContactingADoctor getById(Integer id);
}