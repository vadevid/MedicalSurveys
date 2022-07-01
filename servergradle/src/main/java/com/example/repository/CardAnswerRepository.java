package com.example.repository;

import com.example.entity.CardAnswer;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface CardAnswerRepository extends CrudRepository<CardAnswer, Integer> {
    List<CardAnswer> findAllByCardIdOrderByAnswerDate(Integer id);
}
