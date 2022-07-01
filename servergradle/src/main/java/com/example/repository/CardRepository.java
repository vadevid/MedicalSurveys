package com.example.repository;

import com.example.entity.Card;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer > {
    List<Card> findAllByPatientId(Integer id);
    Card getById(Integer id);
    List<Card> findAllByDoctorId(Integer id);
}
