package com.example.serverspring.repository;

import com.example.serverspring.entity.CardAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardAnswerRepository extends JpaRepository<CardAnswer, Integer> {
    List<CardAnswer> findAllByCardIdOrderByAnswerDate(Integer id);
}