package com.lhind.course.controller;

import com.lhind.course.model.entity.Course;
import com.lhind.course.service.CourseService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String getCourses(Model model) {
        List<Course> courses = courseService.findAll();
        model.addAttribute("courses",courses);

        return "courses";
    }
}
