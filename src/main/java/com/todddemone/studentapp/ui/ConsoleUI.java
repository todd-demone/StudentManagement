package com.todddemone.studentapp.ui;

import java.util.Set;
import com.todddemone.studentapp.service.*;
import com.todddemone.studentapp.domain.*;
import com.todddemone.studentapp.utils.UiInputUtils;
import com.todddemone.studentapp.exceptions.ValidationException;

public class ConsoleUI {
    private final CourseUI courseUI;
    private final StudentUI studentUI;
    private final TeacherUI teacherUI;
    private final EnrollmentUI enrollmentUI;
    private final UiInputUtils uiInputUtils;

    public ConsoleUI(CourseService courseService, StudentService studentService, TeacherService teacherService,
            EnrollmentService enrollmentService, UiInputUtils uiInputUtils) {
        this.courseUI = new CourseUI(courseService, uiInputUtils);
        this.studentUI = new StudentUI(studentService, uiInputUtils);
        this.teacherUI = new TeacherUI(teacherService, uiInputUtils);
        this.enrollmentUI = new EnrollmentUI(enrollmentService, uiInputUtils);
        this.uiInputUtils = uiInputUtils;
        // this.studentService = studentService;
        // this.teacherService = teacherService;
        // this.enrollmentService = enrollmentService;
    }

    public void run() {
        while (true) {
            System.out.println();
            System.out.println("School Management System");
            System.out.println("COURSES");
            System.out.println("1 - Add a course to the school system");
            System.out.println("2 - Remove a course from school system");
            System.out.println("3 - Update a course's details");
            System.out.println("4 - Assign a teacher to a course");
            System.out.println("5 - Get course details");
            System.out.println("6 - Get a list of the enrolled students in a course");
            System.out.println("STUDENTS");
            System.out.println("7 - Add a student to the school system");
            System.out.println("8 - Remove a student from the school system");
            System.out.println("9 - Update a student's details");
            System.out.println("10 - Get a student's details");
            System.out.println("11 - Get a student's course list");
            System.out.println("TEACHERS");
            System.out.println("12 - Add a teacher to the school system");
            System.out.println("13 - Remove a teacher from the school system");
            System.out.println("14 - Update a teacher's details");
            System.out.println("15 - Get a teacher's details");
            System.out.println("16 - Get a teacher's course list");
            System.out.println("ENROLLMENTS");
            System.out.println("17 - Enroll a student in a course");
            System.out.println("18 - Remove a student from a course (Drop course)");
            System.out.println("19 - Update a student's grade in a course");
            System.out.println("20 - Exit");
    
            int choice = uiInputUtils.readInt("Enter your choice");
            System.out.println();
    
            switch (choice) {
                // Course
                case 1 -> courseUI.add();
                case 2 -> courseUI.remove();
                case 3 -> courseUI.update();
                case 4 -> courseUI.getDetails();
                case 5 -> courseUI.addTeacherToCourse();
                // Student
                case 6 -> studentUI.addStudent();
                case 7 -> studentUI.removeStudent();
                case 8 -> studentUI.updateStudent();
                case 9 -> studentUI.getStudentDetails();
                // Teacher
                case 10 -> teacherUI.addTeacher();
                case 11 -> teacherUI.removeTeacher();
                case 12 -> teacherUI.updateTeacher();
                case 13 -> teacherUI.getTeacherDetails();
                case 14 -> teacherUI.getTeachersCourseList();
                // Enrollment
                case 15 -> enrollmentUI.enrollStudentInCourse();
                case 16 -> enrollmentUI.dropStudentFromCourse();
                case 17 -> enrollmentUI.updateGrade();
                case 18 -> enrollmentUI.getCourseEnrollments();
                case 19 -> enrollmentUI.getStudentEnrollments();
                case 20 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
 
    private void addStudent() {
        String name = uiInputUtils.readString("Enter the student name");

        try {
            studentService.add(name);
            System.out.println("Student added successfully");
        } catch (ValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }

    private void addTeacher() {
        String name = uiInputUtils.readString("Enter the teacher name");

        try {
            teacherService.add(name);
            System.out.println("Teacher added successfully");
        } catch (ValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }

    private void addEnrollment() {
        int courseId = uiInputUtils.readInt("Enter the course ID");
        int studentId = uiInputUtils.readInt("Enter the student ID");

        try {
            enrollmentService.add(courseId, studentId);
        } catch (ValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }

    private void addGrade() {
        int id = uiInputUtils.readInt("Enter the enrollment ID");
        int grade = uiInputUtils.readInt("Enter the grade");

        try {
            enrollmentService.addGrade(id, grade);
        } catch (ValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }

    private void listStudentEnrollments() {
        int studentId = uiInputUtils.readInt("Enter student ID");

        try {
            Set<Enrollment> enrollments = studentService.getEnrollments(studentId);
            System.out.println("Enrollments for student ID " + studentId + ":");
            for (Enrollment enrollment : enrollments) {
                System.out.println("- " + enrollment.getCourseId());
            }
        } catch (ValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }

    }

    private void listCourseEnrollments() {
        int courseId = uiInputUtils.readInt("Enter course ID");

        try {
            Set<Enrollment> enrollments = courseService.getEnrollments(courseId);
            System.out.println("Enrollments for course ID " + courseId + ":");
            for (Enrollment enrollment : enrollments) {
                System.out.println("- " + enrollment.getStudentId());
            }
        } catch (ValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }

}