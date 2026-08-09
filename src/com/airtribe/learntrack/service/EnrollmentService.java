package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {
    private final List<Enrollment> enrollments = new ArrayList<>();

    public Enrollment enrollStudent(int studentId, int courseId, StudentService studentService, CourseService courseService)
            throws EntityNotFoundException {
        studentService.findStudentById(studentId);
        courseService.findCourseById(courseId);

        int id = IdGenerator.getNextEnrollmentId();
        Enrollment enrollment = new Enrollment(id, studentId, courseId);
        enrollments.add(enrollment);
        return enrollment;
    }
    public List<Enrollment> getEnrollmentsForStudent(int studentId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId) {
                result.add(e);
            }
        }
        return result;
    }
    public void updateStatus(int enrollmentId, String status) throws EntityNotFoundException {
        for (Enrollment e : enrollments) {
            if (e.getId() == enrollmentId) {
                e.setStatus(status);
                return;
            }
        }
        throw new EntityNotFoundException("Enrollment with ID " + enrollmentId + " not found.");
    }
}
