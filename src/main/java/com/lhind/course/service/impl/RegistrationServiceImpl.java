package com.lhind.course.service.impl;

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
        List<Course> courses = registration.getCourses();
        for(Course course : courses) {
            course.setRegistration(registration);
        }
        return registrationRepository.save(registration);
    }

    @Override
    public Registration updateRegistration(Registration registration) {
        Registration r = findById(registration.getId());
        //TODO Add exception if doesn't exist
        if(r == null) return createRegistration(registration);

        r.setName(registration.getName());
        r.setCourses(registration.getCourses());

        return registrationRepository.save(r);
    }

    @Override
    public void deleteRegistration(int id) {
        //TODO Add exception if doesn't exist
        registrationRepository.delete(findById(id));
    }

    @Override
    public Registration findById(int id) {
        //TODO Add exception if doesn't exist
        return registrationRepository.findById(id);
    }

    @Override
    public List<Registration> findAll() {
        return registrationRepository.findAll();
    }

    @Override
    public Registration addCourse(int registrationId, Course course) {
        Registration registration = findById(registrationId);
        //TODO Add exception if doesn't exist
        course.setRegistration(registration);

        List<Course> courses = (registration.getCourses() != null) ? registration.getCourses() : new ArrayList<>();
        courses.add(course);
        registration.setCourses(courses);

        return registrationRepository.save(registration);
    }

    @Override
    public List<Course> getCourses(int registrationId) {
        Registration registration = registrationRepository.findById(registrationId);
        //TODO Add exception if doesn't exist
        if(registration != null)
            return courseRepository.findByRegistration(registration);
        return new ArrayList<>();
    }
}
