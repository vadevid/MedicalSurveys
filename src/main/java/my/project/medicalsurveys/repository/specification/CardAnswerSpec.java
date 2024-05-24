package my.project.medicalsurveys.repository.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import my.project.medicalsurveys.entity.CardAnswer;
import my.project.medicalsurveys.entity.CardAnswer_;
import my.project.medicalsurveys.entity.Card_;
import org.springframework.data.jpa.domain.Specification;

public class CardAnswerSpec {
    public static Specification<CardAnswer> byCardId(Integer id) {
        return new Specification<CardAnswer>() {
            @Override
            public Predicate toPredicate(Root<CardAnswer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(CardAnswer_.card).get(Card_.id), id);
            }
        };
    }
}
