package com.lhind.course.service;

import com.lhind.course.model.Course;
import com.lhind.course.model.Registration;

import java.util.List;

public interface RegistrationService {
    Registration createRegistration(Registration registration);
    Registration updateRegistration(Registration registration);
    void deleteRegistration(int id);
    Registration findById(int id);
    List<Registration> findAll();
    Registration addCourse(int registrationId, Course course);
    List<Course> getCourses(int registrationId);
}
