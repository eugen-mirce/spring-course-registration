package com.lhind.course.service.impl;

import com.lhind.course.exceptions.CourseServiceException;
import com.lhind.course.model.Course;
import com.lhind.course.model.Registration;
import com.lhind.course.repository.CourseRepository;
import com.lhind.course.service.CourseService;
import com.lhind.course.service.RegistrationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final RegistrationService registrationService;

    public CourseServiceImpl(CourseRepository courseRepository, RegistrationService registrationService) {
        this.courseRepository = courseRepository;
        this.registrationService = registrationService;
    }

    @Override
    public Course createCourse(Course course) {
        if(courseRepository.findByName(course.getName()) == null)
            throw new CourseServiceException("Course with this name exists.");
        Registration registration = course.getRegistration();
        if(registration != null)
            registrationService.createRegistration(registration);
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        Course c = findById(course.getId());
        if(c == null) return createCourse(course);

        c.setName(course.getName());
        c.setDescription(course.getDescription());
        c.setRegistration(course.getRegistration());

        return courseRepository.save(c);
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.delete(findById(id));
    }

    @Override
    public Course findById(int id) {
        Course course = courseRepository.findById(id);
        if(course == null)
            throw new CourseServiceException("Course with this id doesn't exist.");
        return course;
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = courseRepository.findAll();
        return (courses != null) ? courses : new ArrayList<>();
    }
}
