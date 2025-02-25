package com.todddemone.studentapp.ui;

import java.util.Set;
import com.todddemone.studentapp.repository.*;
import com.todddemone.studentapp.service.*;
import com.todddemone.studentapp.domain.*;
import com.todddemone.studentapp.utils.UiInputUtils;

public class MainUI {
    private static final Repository<Course> courseRepository = new Repository<>();
    private static final Repository<Student> studentRepository = new Repository<>();
    private static final Repository<Teacher> teacherRepository = new Repository<>();
    private static final EnrollmentRepository enrollmentRepository = new EnrollmentRepository();

    private static final CourseService courseService = new CourseService(courseRepository, teacherRepository,
            enrollmentRepository);
    private static final StudentService studentService = new StudentService(studentRepository, enrollmentRepository);
    private static final TeacherService teacherService = new TeacherService(teacherRepository);
    private static final EnrollmentService enrollmentService = new EnrollmentService(enrollmentRepository,
            courseRepository, studentRepository);

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("Student Management System");
            System.out.println("1 - Add course");
            System.out.println("2 - Add student");
            System.out.println("3 - Add teacher");
            System.out.println("4 - Enroll a student in a course");
            System.out.println("5 - Add/update a grade");
            System.out.println("6 - List a student's enrollments");
            System.out.println("7 - List a course's enrollments");
            System.out.println("8 - Exit the program");

            int choice = UiInputUtils.readInt("Enter your choice");
            System.out.println();

            switch (choice) {
            case 1 -> addCourse();
            case 2 -> addStudent();
            case 3 -> addTeacher();
            case 4 -> addEnrollment();
            case 5 -> addGrade();
            case 6 -> listStudentEnrollments();
            case 7 -> listCourseEnrollments();
            case 8 -> {
                System.out.println("Exiting...");
                return;
            }
            default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addCourse() {
        Integer id = UiInputUtils.readInt("Enter the course ID");
        String name = UiInputUtils.readString("Enter the course name");
        Integer teacherId = UiInputUtils.readInt("Enter teacher ID");
        String courseCode = UiInputUtils.readString("Enter the course code").trim().toUpperCase();

        try {
            courseService.add(id, name, teacherId, courseCode);
            System.out.println("Course added successfully");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addStudent() {
        int id = UiInputUtils.readInt("Enter the student ID");
        String name = UiInputUtils.readString("Enter the student name");

        try {
            studentService.add(id, name);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addTeacher() {
        int id = UiInputUtils.readInt("Enter the teacher ID");
        String name = UiInputUtils.readString("Enter the teacher name");

        try {
            teacherService.add(id, name);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addEnrollment() {
        int courseId = UiInputUtils.readInt("Enter the course ID");
        int studentId = UiInputUtils.readInt("Enter the student ID");

        try {
            enrollmentService.add(courseId, studentId);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addGrade() {
        int courseId = UiInputUtils.readInt("Enter the course ID");
        int studentId = UiInputUtils.readInt("Enter the student ID");
        int grade = UiInputUtils.readInt("Enter the grade");

        try {
            enrollmentService.addGrade(courseId, studentId, grade);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listStudentEnrollments() {
        int studentId = UiInputUtils.readInt("Enter student ID");

        try {
            Set<Enrollment> enrollments = studentService.getEnrollments(studentId);
            System.out.println("Enrollments for student ID " + studentId + ":");
            for (Enrollment enrollment : enrollments) {
                System.out.println("- " + enrollment.getCourse());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static void listCourseEnrollments() {
        int courseId = UiInputUtils.readInt("Enter course ID");

        try {
            Set<Enrollment> enrollments = courseService.getEnrollments(courseId);
            System.out.println("Enrollments for course ID " + courseId + ":");
            for (Enrollment enrollment : enrollments) {
                System.out.println("- " + enrollment.getStudent());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}