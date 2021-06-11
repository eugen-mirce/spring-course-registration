package com.lhind.course.service.impl;

import com.lhind.course.exceptions.RegistrationServiceException;
import com.lhind.course.model.Course;
import com.lhind.course.model.Registration;
import com.lhind.course.repository.CourseRepository;
import com.lhind.course.repository.RegistrationRepository;
import com.lhind.course.service.RegistrationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final CourseRepository courseRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository, CourseRepository courseRepository) {
        this.registrationRepository = registrationRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Registration createRegistration(Registration registration) {
        if(registrationRepository.findByName(registration.getName()) != null)
            throw new RegistrationServiceException("Registration with this name exists.");

        List<Course> courses = registration.getCourses();
        for(Course course : courses) {
            course.setRegistration(registration);
        }
        return registrationRepository.save(registration);
    }

    @Override
    public Registration updateRegistration(Registration registration) {
        Registration r = findById(registration.getId());
        if(r == null) return createRegistration(registration);

        r.setName(registration.getName());
        r.setCourses(registration.getCourses());

        return registrationRepository.save(r);
    }

    @Override
    public void deleteRegistration(int id) {
        registrationRepository.delete(findById(id));
    }

    @Override
    public Registration findById(int id) {
        Registration registration = registrationRepository.findById(id);
        if(registration == null) throw new RegistrationServiceException("Registration for this id doesn't exist.");
        return registration;
    }

    @Override
    public List<Registration> findAll() {
        List<Registration> registrations = registrationRepository.findAll();
        return (registrations != null) ? registrations : new ArrayList<>();
    }

    @Override
    public Registration addCourse(int registrationId, Course course) {
        Registration registration = findById(registrationId);
        if(registration == null) throw new RegistrationServiceException("Registration for this id doesn't exist.");

        course.setRegistration(registration);

        List<Course> courses = (registration.getCourses() != null) ? registration.getCourses() : new ArrayList<>();
        courses.add(course);
        registration.setCourses(courses);

        return registrationRepository.save(registration);
    }

    @Override
    public List<Course> getCourses(int registrationId) {
        Registration registration = registrationRepository.findById(registrationId);
        if(registration == null) throw new RegistrationServiceException("Registration for this id doesn't exist.");
        List<Course> returnValue = courseRepository.findAllByRegistration(registration);
        return (returnValue != null) ? returnValue : new ArrayList<>();
    }
}
