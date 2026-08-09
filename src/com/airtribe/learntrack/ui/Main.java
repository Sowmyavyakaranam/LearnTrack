package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.Scanner;

public class Main {

    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();
    private static final EnrollmentService enrollmentService = new EnrollmentService();

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(" Welcome to LearnTrack Console System ");

        boolean exit=false;
        while (!exit) {
            printMainMenu();
            int choice = readIntInput("Select an option: ");

            switch (choice) {
                case 1 -> handleStudentMenu();
                case 2 -> handleCourseMenu();
                case 3 -> handleEnrollmentMenu();
                case 0 -> {
                    System.out.println("Exiting LearnTrack. Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static void printMainMenu() {
        System.out.println("\n---Select from MENU Options: ---");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Enrollment Management");
        System.out.println("0. Exit");
    }


    private static void handleStudentMenu() {
        System.out.println("\n--- Student Management ---");
        System.out.println("1. Add Student (With Email)");
        System.out.println("2. Add Student (Without Email - Method Overloading Demo)");
        System.out.println("3. View All Students");
        System.out.println("4. Search Student by ID");
        System.out.println("5. Update Student Details");
        System.out.println("6. Deactivate Student ");
        System.out.println("0. Back to Main Menu");
        int option = readIntInput("Choice: ");

        try {
            switch (option) {
                case 1 -> {
                    System.out.print("First Name: ");
                    String fn = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String ln = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Batch: ");
                    String batch = scanner.nextLine();

                    // Calls overloaded addStudent with 4 parameters
                    Student s = studentService.addStudent(fn, ln, email, batch);
                    System.out.println("Student created successfully: " + s.getDisplayName());
                }
                case 2 -> {
                    System.out.print("First Name: ");
                    String fn = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String ln = scanner.nextLine();
                    System.out.print("Batch: ");
                    String batch = scanner.nextLine();

                    // Calls overloaded addStudent with 3 parameters
                    Student s = studentService.addStudent(fn, ln, batch);
                    System.out.println("Student created (without email): " + s.getDisplayName());
                }
                case 3 -> {
                    var students = studentService.listStudents();
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        students.forEach(s -> System.out.println(s.getDisplayName()));
                    }
                }
                case 4 -> {
                    int id = readIntInput("Enter Student ID: ");
                    Student s = studentService.findStudentById(id);
                    System.out.println(s.getDisplayName());
                }
                case 5 -> {
                    int id = readIntInput("Enter Student ID to update: ");
                    // Verify student exists before asking for inputs
                    studentService.findStudentById(id);

                    System.out.print("Enter New First Name: ");
                    String fn = scanner.nextLine();
                    System.out.print("Enter New Last Name: ");
                    String ln = scanner.nextLine();
                    System.out.print("Enter New Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter New Batch: ");
                    String batch = scanner.nextLine();

                    studentService.updateStudent(id, fn, ln, email, batch);
                    System.out.println("Student details updated successfully.");
                }
                case 6 -> {
                    int id = readIntInput("Enter Student ID to deactivate: ");
                    studentService.deactivateStudent(id);
                    System.out.println("Student marked as inactive.");
                }
                case 0 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    private static void handleCourseMenu() {
        System.out.println("\n--- Course Management ---");
        System.out.println("1. Add Course");
        System.out.println("2. View All Courses");
        System.out.println("3. Activate/Deactivate a course");
        System.out.println("0. Back to Main Menu");
        int option = readIntInput("Choice: ");

        try {
            switch (option) {
                case 1 -> {
                    System.out.print("Course Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Description: ");
                    String desc = scanner.nextLine();
                    int weeks = readIntInput("Duration (weeks): ");
                    Course c = courseService.addCourse(name, desc, weeks);
                    System.out.println("Course created: " + c);
                }
                case 2 -> {
                    var courses = courseService.getAllCourses();
                    if (courses.isEmpty()) {
                        System.out.println("No courses found.");
                    } else {
                        courses.forEach(System.out::println);
                    }
                }
                case 3 -> {
                    int id = readIntInput("Enter Course ID: ");
                    System.out.print("Set Active? (true/false): ");
                    boolean active = Boolean.parseBoolean(scanner.nextLine());
                    courseService.setCourseStatus(id, active);
                    System.out.println("Course status updated.");
                }
                case 0 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void handleEnrollmentMenu() {
        System.out.println("\n--- Enrollment Management ---");
        System.out.println("1. Enroll Student in Course");
        System.out.println("2. View Enrollments for Student");
        System.out.println("3. Update Enrollment Status");
        System.out.println("0. Back to Main Menu");
        int option = readIntInput("Choice: ");

        try {
            switch (option) {
                case 1 -> {
                    int sid = readIntInput("Enter Student ID: ");
                    int cid = readIntInput("Enter Course ID: ");
                    Enrollment e = enrollmentService.enrollStudent(sid, cid, studentService, courseService);
                    System.out.println("Enrolled successfully: " + e);
                }
                case 2 -> {
                    int sid = readIntInput("Enter Student ID: ");
                    var list = enrollmentService.getEnrollmentsForStudent(sid);
                    if (list.isEmpty()) {
                        System.out.println("No enrollments found for student ID: " + sid);
                    } else {
                        list.forEach(System.out::println);
                    }
                }
                case 3 -> {
                    int eid = readIntInput("Enter Enrollment ID: ");
                    System.out.print("Enter Status (COMPLETED / CANCELLED / ACTIVE): ");
                    String status = scanner.nextLine().toUpperCase();
                    enrollmentService.updateStatus(eid, status);
                    System.out.println("Enrollment status updated.");
                }
                case 0 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int readIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }


    }
}
