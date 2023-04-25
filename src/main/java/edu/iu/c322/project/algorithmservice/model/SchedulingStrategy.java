package edu.iu.c322.project.algorithmservice.model;

import java.util.List;

public interface SchedulingStrategy {
    String getName();
    String getDescription();
    List<Course> schedule(List<Course> shoppingCart);
}
