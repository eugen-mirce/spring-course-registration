package com.lhind.course.repository;

import com.lhind.course.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findById(int id);
    List<User> findAll();
    User findByFirstNameAndLastName(String firstName, String lastName);
}
