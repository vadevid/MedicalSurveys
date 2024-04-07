package my.project.medicalsurveys.repository;

import my.project.medicalsurveys.entity.User;

public interface UserRepository {

    User findByLogin(String login);

    void save(User user);
}
