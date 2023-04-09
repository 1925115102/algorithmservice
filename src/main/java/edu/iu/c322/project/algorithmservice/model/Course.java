package edu.iu.c322.project.algorithmservice.model;

public class Course {
    private int id;
    private String name;
    private String description;
    private String instructor;
    private TimeSlot timeSlot;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructor() {
        return instructor;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }
}
