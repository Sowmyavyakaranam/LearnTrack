# LearnTrack
Student &amp; Course Management System built using Core Java

## Project Description
LearnTrack is a console-based Student & Course Management System built using Core Java.
It will allow admins to manage:
* Students
* Courses
* Enrollments
### Key Features
* **Student Management:** Create (with/without email via constructor & method overloading), view, search, update,and remove students.
* **Course Management:** Add courses, list all courses, and check course active status.
* **Enrollment Management:** Enroll students into active courses, view enrollment status (ACTIVE, COMPLETED, CANCELLED), and query student enrollments.
* **Robust Error Handling:** Custom checked exception (`EntityNotFoundException`) and console input safety validation against non-numeric entries (`NumberFormatException`).

---

## How to Compile and Run

### Prerequisites
* Java Development Kit (JDK 17 or higher)
* IntelliJ IDEA or standard Command Line terminal

---

### Option 1: Running from IntelliJ IDEA
1. Open the project in IntelliJ IDEA.
2. Navigate to `src/com/airtribe/learntrack/ui/Main.java`.
3. Right-click `Main.java` and select **Run 'Main.main()'** (or press `Shift + F10`).

---

### Option 2: Compiling and Running via Command Line

1. Open your terminal and navigate to the project root directory:
   cd /path/to/LearnTrack
2. Create an output directory for compiled codes: mkdir -p out
3. Compile all Java source files:javac -d out (Get-ChildItem -Recurse -Filter *.java src).FullName
4. Run the application: java -cp out com.airtribe.learntrack.ui.Main

-------------------
## Project Architecture & Packages
- `com.airtribe.learntrack.entity` - Core entities (Person, Student, Course, Enrollment,Trainer)
- `com.airtribe.learntrack.service` - Business logic using ArrayList storage
- `com.airtribe.learntrack.exception` - Custom domain exceptions
- `com.airtribe.learntrack.util` - Static helper utilities
- `com.airtribe.learntrack.ui` - Console application entry point

## Class Diagram

```mermaid
classDiagram
    %% Core Domain Models & Inheritance
    class Person {
        <<abstract>>
        # int id
        # String firstName
        # String lastName
        # String email
        + getDisplayName()* String
    }

    class Student {
        - boolean active
        + getDisplayName() String
        + isActive() boolean
        + setActive(boolean active) void
    }

    class Trainer {
        - String specialization
        + getDisplayName() String
        + getSpecialization() String
    }

    class Course {
        - int courseId
        - String title
        - boolean active
        + getCourseId() int
        + isTitle() String
        + isActive() boolean
    }

    class Enrollment {
        - int enrollmentId
        - Student student
        - Course course
        - EnrollmentStatus status
        + getEnrollmentId() int
        + getStatus() EnrollmentStatus
    }

    
    %% Application Services
    class StudentService {
        - List~Student~ students
        + addStudent(Student student) void
        + findStudentById(int id) Student
        + deactivateStudent(int id) void
        + getAllStudents() List~Student~
    }

    class CourseService {
        - List~Course~ courses
        + addCourse(Course course) void
        + findCourseById(int id) Course
        + toggleCourseStatus(int id) void
        + getAllCourses() List~Course~
    }

    class EnrollmentService {
        - List~Enrollment~ enrollments
        + enrollStudent(Student student, Course course) Enrollment
        + getEnrollmentsByStudentId(int studentId) List~Enrollment~
    }

    %% Helpers & Entry Point
    class IdGenerator {
        - static int studentIdCounter
        - static int courseIdCounter
        - static int enrollmentIdCounter
        + static getNextStudentId() int
        + static getNextCourseId() int
        + static getNextEnrollmentId() int
    }

    class EntityNotFoundException {
        + EntityNotFoundException(String message)
    }

    class Main {
        - static StudentService studentService
        - static CourseService courseService
        - static EnrollmentService enrollmentService
        + main(String[] args) void
    }

    %% Inheritance Relationships
    Person <|-- Student
    Person <|-- Trainer

    %% Service Aggregations
    StudentService "1" o-- "*" Student
    CourseService "1" o-- "*" Course
    EnrollmentService "1" o-- "*" Enrollment

    %% Composition & Association
    Enrollment "1" --> "1" Student
    Enrollment "1" --> "1" Course

    %% Dependencies
    Main --> StudentService
    Main --> CourseService
    Main --> EnrollmentService
    Main ..> IdGenerator
    Main ..> EntityNotFoundException