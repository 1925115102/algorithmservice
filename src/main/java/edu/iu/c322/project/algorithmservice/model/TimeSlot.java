package edu.iu.c322.project.algorithmservice.model;

import java.util.ArrayList;
import java.util.List;

public class TimeSlot {
    private int id;
    private String startTime;
    private String endTime;
    private List<String> daysOfWeek;
    private final String[] weekday = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday","Sunday"};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<String> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(List<Integer> daysOfWeek) {
        for (int i:daysOfWeek) {
            this.daysOfWeek.add(weekday[i]);
        }
    }
}
