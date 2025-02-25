package com.todddemone.studentapp.ui;

import java.util.Set;
import com.todddemone.studentapp.service.*;
import com.todddemone.studentapp.domain.*;
import com.todddemone.studentapp.utils.UiInputUtils;

public class ConsoleUI {
    private final CourseService courseService;
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final EnrollmentService enrollmentService;
    private final UiInputUtils uiInputUtils;

    public ConsoleUI(CourseService courseService, StudentService studentService, TeacherService teacherService,
            EnrollmentService enrollmentService, UiInputUtils uiInputUtils) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.enrollmentService = enrollmentService;
        this.uiInputUtils = uiInputUtils;
    }

    public void run() {
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

            int choice = uiInputUtils.readInt("Enter your choice");
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
    

    private void addCourse() {
        Integer id = uiInputUtils.readInt("Enter the course ID");
        String name = uiInputUtils.readString("Enter the course name");
        Integer teacherId = uiInputUtils.readInt("Enter teacher ID");
        String courseCode = uiInputUtils.readString("Enter the course code").trim().toUpperCase();

        try {
            courseService.add(id, name, teacherId, courseCode);
            System.out.println("Course added successfully");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addStudent() {
        int id = uiInputUtils.readInt("Enter the student ID");
        String name = uiInputUtils.readString("Enter the student name");

        try {
            studentService.add(id, name);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addTeacher() {
        int id = uiInputUtils.readInt("Enter the teacher ID");
        String name = uiInputUtils.readString("Enter the teacher name");

        try {
            teacherService.add(id, name);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addEnrollment() {
        int courseId = uiInputUtils.readInt("Enter the course ID");
        int studentId = uiInputUtils.readInt("Enter the student ID");

        try {
            enrollmentService.add(courseId, studentId);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addGrade() {
        int courseId = uiInputUtils.readInt("Enter the course ID");
        int studentId = uiInputUtils.readInt("Enter the student ID");
        int grade = uiInputUtils.readInt("Enter the grade");

        try {
            enrollmentService.addGrade(courseId, studentId, grade);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listStudentEnrollments() {
        int studentId = uiInputUtils.readInt("Enter student ID");

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

    private void listCourseEnrollments() {
        int courseId = uiInputUtils.readInt("Enter course ID");

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