package com.example.repository;

import com.example.entity.ContactingADoctor;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface ContactingADoctorRepository extends CrudRepository<ContactingADoctor, Integer> {
    List<ContactingADoctor> findAllByDoctorId(Integer id);
    ContactingADoctor getById(Integer id);
}
