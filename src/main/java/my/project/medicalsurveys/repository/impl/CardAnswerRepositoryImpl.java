package my.project.medicalsurveys.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import my.project.medicalsurveys.entity.CardAnswer;
import my.project.medicalsurveys.entity.CardAnswer_;
import my.project.medicalsurveys.entity.Card_;
import my.project.medicalsurveys.model.response.GetCardAllAnswerResponse;
import my.project.medicalsurveys.repository.CardAnswerRepository;
import my.project.medicalsurveys.repository.specification.CardAnswerSpec;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CardAnswerRepositoryImpl implements CardAnswerRepository {

    private final EntityManager manager;

    public CardAnswerRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    @Transactional
    public void save(CardAnswer cardAnswer) {
        manager.persist(cardAnswer);
    }

    @Override
    public List<GetCardAllAnswerResponse> getAllAnswer(Integer id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<GetCardAllAnswerResponse> query = builder.createQuery(GetCardAllAnswerResponse.class);
        Root<CardAnswer> root = query.from(CardAnswer.class);

        query.multiselect(
                root.get(CardAnswer_.id),
                root.get(CardAnswer_.card).get(Card_.name),
                root.get(CardAnswer_.answer),
                root.get(CardAnswer_.answerDate),
                root.get(CardAnswer_.card).get(Card_.minValue),
                root.get(CardAnswer_.card).get(Card_.maxValue)
        );

        query.where(CardAnswerSpec.byCardId(id).toPredicate(root, query, builder));

        query.orderBy(builder.asc(root.get(CardAnswer_.answerDate)));

        return manager.createQuery(query).getResultList();
    }
}
