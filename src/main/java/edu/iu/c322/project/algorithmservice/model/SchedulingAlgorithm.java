package edu.iu.c322.project.algorithmservice.model;

import java.util.List;

public interface SchedulingAlgorithm {
    String getName();
    String getDescription();
    List<Course> schedule();
}
