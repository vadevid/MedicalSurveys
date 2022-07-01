package com.example.repository;

import com.example.entity.DefaultValue;
import com.example.entity.Patient;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
@Repository
public interface DefaultValueRepository extends CrudRepository<DefaultValue, Integer> {
    DefaultValue getByPatientOrderById(Patient patient);
    DefaultValue findFirstByPatientOrderByIdDesc(Patient patient);

}
