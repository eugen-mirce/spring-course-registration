package com.lhind.course.service;

import com.lhind.course.model.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);
    Course updateCourse(Course course);
    void deleteCourse(int id);
    Course findById(int id);
    List<Course> findAll();
}
