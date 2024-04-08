package my.project.medicalsurveys.repository.impl;

import jakarta.persistence.EntityManager;
import my.project.medicalsurveys.entity.CardAnswer;
import my.project.medicalsurveys.repository.CardAnswerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CardAnswerRepositoryImpl implements CardAnswerRepository {

    private final EntityManager manager;

    public CardAnswerRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void save(CardAnswer cardAnswer) {
        manager.persist(cardAnswer);
    }
}
