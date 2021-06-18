package com.lhind.course.repository;

import com.lhind.course.model.entity.Course;
import com.lhind.course.model.entity.Registration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
    Course findById(int id);
    List<Course> findAll();
    List<Course> findAllByRegistration(Registration registration);
    Course findByName(String name);
}
