package edu.iu.c322.project.algorithmservice.controller;

import edu.iu.c322.project.algorithmservice.model.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/algorithm")
public class AlgorithmController {

    private final WebClient courseservice;

    private final WebClient scheduleservice;


    @PostMapping("/student/{studentId}/schedule")
    public void scheduleCourses(@PathVariable int studentId) {
        Student student = scheduleController.findStudent(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        List<Course> coursesInShoppingCart = student.getShoppingCart().stream()
                .map(request -> scheduleController.find(request.getCourseId()))
                .collect(Collectors.toList());

        SchedulingStrategy strategy;
        if ("morning".equalsIgnoreCase(student.getRequest())) {
            strategy = new MorningPreferenceSchedulingStrategy();
        } else if ("afternoon".equalsIgnoreCase(student.getRequest())) {
            strategy = new AfternoonPreferenceSchedulingStrategy();
        } else {
            throw new RuntimeException("Invalid scheduling preference");
        }

        List<Course> sortedCourses = strategy.schedule(coursesInShoppingCart);

        for (Course course : sortedCourses) {
            MyCourse myCourse = new MyCourse();
            myCourse.setName(course.getName());
            myCourse.setDescription(course.getDescription());
            myCourse.setInstructor(course.getInstructor());
            myCourse.setStartTime(course.getTimeSlots().get(0).getStartTime());
            myCourse.setEndTime(course.getTimeSlots().get(0).getEndTime());
            myCourse.setDaysOfWeek(course.getTimeSlots().get(0).getDaysOfWeek());
            myCourse.setStudent(student);

            student.getCourselist().add(myCourse);
        }

        scheduleController.updateStudentCourses(studentId, student.getCourselist());
    }



}
