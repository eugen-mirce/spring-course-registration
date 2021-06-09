package com.lhind.course.response;

import java.util.List;

public class RegistrationRest {
    private int id;
    private String name;
    private List<CourseRest> courses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseRest> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseRest> courses) {
        this.courses = courses;
    }
}
