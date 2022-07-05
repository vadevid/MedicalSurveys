package com.example.serverspring.repository;

import com.example.serverspring.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    List<Card> findAllByPatientId(Integer id);
    Card getById(Integer id);
    List<Card> findAllByDoctorId(Integer id);
}