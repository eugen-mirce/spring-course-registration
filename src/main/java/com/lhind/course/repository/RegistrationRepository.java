package com.lhind.course.repository;

import com.lhind.course.model.entity.Registration;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegistrationRepository extends CrudRepository<Registration,Integer> {
    Registration findById(int id);
    List<Registration> findAll();
    Registration findByName(String name);
}
