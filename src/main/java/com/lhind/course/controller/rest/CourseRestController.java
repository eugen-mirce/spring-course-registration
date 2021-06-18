package com.lhind.course.controller.rest;

import com.lhind.course.model.entity.Course;
import com.lhind.course.model.response.CourseRest;
import com.lhind.course.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseRestController {
    private CourseService courseService;

    public CourseRestController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(path = "{courseId}")
    public CourseRest getCourse(@PathVariable int courseId) {
        Course course = courseService.findById(courseId);

        CourseRest returnValue = new CourseRest();
        BeanUtils.copyProperties(course,returnValue);
        return returnValue;
    }

    @GetMapping
    public List<CourseRest> getCourses() {
        List<Course> courses = courseService.findAll();
        List<CourseRest> returnValue = new ArrayList<>();

        for(Course c : courses) {
            CourseRest courseRest = new CourseRest();
            BeanUtils.copyProperties(c,courseRest);
            returnValue.add(courseRest);
        }

        return returnValue;
    }

    @PostMapping
    public CourseRest createCourse(@RequestBody Course course) {
        course = courseService.createCourse(course);

        CourseRest returnValue = new CourseRest();
        BeanUtils.copyProperties(course,returnValue);
        return returnValue;
    }

    @PutMapping(path = "{courseId}")
    public CourseRest updateCourse(@PathVariable int courseId, @RequestBody Course course) {
        course.setId(courseId);
        course = courseService.updateCourse(course);

        CourseRest returnValue = new CourseRest();
        BeanUtils.copyProperties(course,returnValue);
        return returnValue;
    }

    @DeleteMapping(path = "{courseId}")
    public String deleteCourse(@PathVariable int courseId) {
        courseService.deleteCourse(courseId);
        return "SUCCESS";
    }

}
