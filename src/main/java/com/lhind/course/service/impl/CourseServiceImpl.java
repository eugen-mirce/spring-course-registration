package com.lhind.course.service.impl;

import com.lhind.course.model.Course;
import com.lhind.course.model.Registration;
import com.lhind.course.repository.CourseRepository;
import com.lhind.course.service.CourseService;
import com.lhind.course.service.RegistrationService;
import org.springframework.stereotype.Service;

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
        //TODO Check if course exists
        Registration registration = course.getRegistration();
        if(registration != null)
            registrationService.createRegistration(registration);
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        Course c = findById(course.getId());
        //TODO Add exception if doesn't exist
        if(c == null) return createCourse(course);

        c.setName(course.getName());
        c.setDescription(course.getDescription());
        c.setRegistration(course.getRegistration());

        return courseRepository.save(c);
    }

    @Override
    public void deleteCourse(int id) {
        //TODO Add exception if doesn't exist
        courseRepository.delete(findById(id));
    }

    @Override
    public Course findById(int id) {
        //TODO Add exception if doesn't exist
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
