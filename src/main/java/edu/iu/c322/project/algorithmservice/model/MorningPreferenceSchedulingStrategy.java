package edu.iu.c322.project.algorithmservice.model;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class MorningPreferenceSchedulingStrategy implements SchedulingStrategy {

    @Override
    public String getName() {
        return "Morning Preference";
    }

    @Override
    public String getDescription() {
        return "This strategy prioritizes scheduling more classes in the morning.";
    }

    @Override
    public List<Course> schedule(List<Course> shoppingCart) {
        List<Course> courses = getAllCourses(); // This method should be implemented to fetch all available courses
        return courses.stream()
                .sorted(Comparator.comparing(course -> earliestTimeSlot(course.getTimeSlots())))
                .collect(Collectors.toList());
    }

    private LocalTime earliestTimeSlot(List<TimeSlot> timeSlots) {
        return timeSlots.stream()
                .map(timeSlot -> LocalTime.parse(timeSlot.getStartTime()))
                .min(LocalTime::compareTo)
                .orElse(LocalTime.MAX);
    }
}
