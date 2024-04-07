package my.project.medicalsurveys.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import my.project.medicalsurveys.entity.User;
import my.project.medicalsurveys.repository.UserRepository;
import my.project.medicalsurveys.repository.specification.UserSpec;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final EntityManager manager;

    public UserRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public User findByLogin(String login) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        query.where(UserSpec.byLogin(login).toPredicate(root, query, builder));
        query.select(root);

        List<User> result = manager.createQuery(query).getResultList();
        if (result.isEmpty()) return null;
        return result.get(0);
    }

    @Override
    public void save(User user) {
        manager.persist(user);
    }
}
