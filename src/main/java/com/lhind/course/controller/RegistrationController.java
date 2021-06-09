package com.lhind.course.controller;

import com.lhind.course.model.Course;
import com.lhind.course.model.Registration;
import com.lhind.course.response.CourseRest;
import com.lhind.course.response.RegistrationRest;
import com.lhind.course.service.RegistrationService;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping(path = "{registrationId}")
    public RegistrationRest getRegistration(@PathVariable int registrationId) {
        Registration registration = registrationService.findById(registrationId);
        RegistrationRest returnValue = new RegistrationRest();
        BeanUtils.copyProperties(registration,returnValue);
        List<CourseRest> courses = new ArrayList<>();
        for(Course course : registration.getCourses()) {
            CourseRest courseRest = new CourseRest();
            BeanUtils.copyProperties(course,courseRest);
            courses.add(courseRest);
        }
        returnValue.setCourses(courses);
        return returnValue;
    }

    @GetMapping
    public List<RegistrationRest> getAllRegistrations() {
        List<Registration> registrations = registrationService.findAll();
        List<RegistrationRest> returnValue = new ArrayList<>();

        for(Registration registration : registrations) {
            RegistrationRest registrationRest = new RegistrationRest();
            BeanUtils.copyProperties(registration,registrationRest);

            List<CourseRest> courses = new ArrayList<>();
            for(Course course : registration.getCourses()) {
                CourseRest courseRest = new CourseRest();
                BeanUtils.copyProperties(course,courseRest);
                courses.add(courseRest);
            }
            registrationRest.setCourses(courses);

            returnValue.add(registrationRest);
        }

        return returnValue;
    }

    @PostMapping
    public RegistrationRest createRegistration(@RequestBody Registration registration) {
        registration = registrationService.createRegistration(registration);

        RegistrationRest returnValue = new RegistrationRest();
        BeanUtils.copyProperties(registration,returnValue);

        List<CourseRest> courses = new ArrayList<>();
        for(Course course : registration.getCourses()) {
            CourseRest courseRest = new CourseRest();
            BeanUtils.copyProperties(course,courseRest);
            courses.add(courseRest);
        }
        returnValue.setCourses(courses);

        return returnValue;
    }

    @DeleteMapping(path = "{registrationId}")
    public String deleteRegistration(@PathVariable int registrationId) {
        registrationService.deleteRegistration(registrationId);
        return "SUCCESS";
    }

    @PostMapping(path = "{registrationId}/courses")
    public RegistrationRest addCourse(@PathVariable int registrationId, @RequestBody Course course) {
        Registration registration = registrationService.addCourse(registrationId,course);
        RegistrationRest returnValue = new RegistrationRest();
        BeanUtils.copyProperties(registration,returnValue);

        List<CourseRest> courses = new ArrayList<>();
        for(Course c : registration.getCourses()) {
            CourseRest courseRest = new CourseRest();
            BeanUtils.copyProperties(c,courseRest);
            courses.add(courseRest);
        }
        returnValue.setCourses(courses);
        return returnValue;
    }

    @GetMapping(path = "{registrationId}/courses")
    public List<CourseRest> getCourses(@PathVariable int registrationId) {
        List<Course> courses = registrationService.getCourses(registrationId);
        List<CourseRest> returnValue = new ArrayList<>();

        for(Course course : courses) {
            CourseRest courseRest = new CourseRest();
            BeanUtils.copyProperties(course,courseRest);
            returnValue.add(courseRest);
        }
        return returnValue;
    }
}
