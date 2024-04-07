package my.project.medicalsurveys.repository.impl;

import jakarta.persistence.EntityManager;
import my.project.medicalsurveys.entity.Role;
import my.project.medicalsurveys.repository.RoleRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    private final EntityManager manager;

    public RoleRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void save(Role role) {
        manager.persist(role);
    }
}
