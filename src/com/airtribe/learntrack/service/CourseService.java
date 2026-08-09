package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private final List<Course> courses = new ArrayList<>();

    public Course addCourse(String name, String description, int durationInWeeks) {
        int id = IdGenerator.getNextCourseId();
        Course course = new Course(id, name, description, durationInWeeks);
        courses.add(course);
        return course;
    }
    public List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }
    public Course findCourseById(int id) throws EntityNotFoundException {
        for (Course c : courses) {
            if (c.getId() == id) {
                return c;
            }
        }
        throw new EntityNotFoundException("Course with ID " + id + " not found.");
    }
    public void setCourseStatus(int id, boolean active) throws EntityNotFoundException {
        Course course = findCourseById(id);
        course.setActive(active);
    }

}
