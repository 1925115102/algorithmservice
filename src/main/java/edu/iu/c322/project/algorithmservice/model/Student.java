package edu.iu.c322.project.algorithmservice.model;

import java.util.List;

public class Student {
    int id;
    List<Course> courselist;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Course> getCourselist() {
        return courselist;
    }

    public void setCourselist(List<Course> courselist) {
        this.courselist = courselist;
    }
}
