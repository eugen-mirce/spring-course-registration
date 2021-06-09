package com.lhind.course.repository;

import com.lhind.course.model.Course;
import com.lhind.course.model.Registration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
    Course findById(int id);
    List<Course> findAll();
    List<Course> findByRegistration(Registration registration);
}
