package com.todddemone.studentapp.ui;

import java.util.Set;
import com.todddemone.studentapp.repository.*;
import com.todddemone.studentapp.domain.*;
import com.todddemone.studentapp.utils.*;

public class MainUI {
    private static final Repository<Course> courseRepository = new Repository<>();
    private static final Repository<Student> studentRepository = new Repository<>();
    private static final Repository<Teacher> teacherRepository = new Repository<>();
    private static final EnrollmentRepository enrollmentRepository = new EnrollmentRepository();

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("Student Management System");
            System.out.println("1 - Add course");
            System.out.println("2 - Add student");
            System.out.println("3 - Add teacher");
            System.out.println("4 - Enroll a student in a course");
            System.out.println("5 - Add/update a grade");
            System.out.println("6 - List a student's courses");
            System.out.println("7 - List a course's students");
            System.out.println("8 - Exit the program");

            int choice = UiInputUtils.readInt("Enter your choice");
            System.out.println();

            switch (choice) {
                case 1 -> addCourse();
                case 2 -> addStudent();
                case 3 -> addTeacher();
                case 4 -> addEnrollment();
                case 5 -> addGrade();
                case 6 -> listCoursesOfStudent();
                case 7 -> listStudentsOfCourse();
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
        Teacher teacher = teacherRepository.get(teacherId);
        String courseCode = UiInputUtils.readString("Enter the course code").trim().toUpperCase();

        try {
            courseRepository.add(new Course(id, name, teacher, courseCode));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addStudent() {
        int id = UiInputUtils.readInt("Enter the student ID");
        String name = UiInputUtils.readString("Enter the student name");

        try {
            studentRepository.add(new Student(id, name));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addTeacher() {
        int id = UiInputUtils.readInt("Enter the teacher ID");
        String name = UiInputUtils.readString("Enter the teacher name");

        try {
            teacherRepository.add(new Teacher(id, name));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addEnrollment() {
        int courseId = UiInputUtils.readInt("Enter the course ID");
        int studentId = UiInputUtils.readInt("Enter the student ID");

        try {
            Course course = courseRepository.get(courseId);
            Student student = studentRepository.get(studentId);
            enrollmentRepository.addEnrollment(new Enrollment(course, student));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addGrade() {
        int courseId = UiInputUtils.readInt("Enter the course ID");
        int studentId = UiInputUtils.readInt("Enter the student ID");
        int grade = UiInputUtils.readInt("Enter the grade");

        try {
            Enrollment enrollment = enrollmentRepository.getEnrollment(courseId, studentId);
            enrollment.addGrade(grade);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listCoursesOfStudent() {
        int studentId = UiInputUtils.readInt("Enter student ID");

        try {
            Student student = studentRepository.get(studentId);
            Set<Enrollment> enrollments = student.getEnrollments();
            System.out.println(student.getName() + "'s Course List:");
            for (Enrollment enrollment : enrollments) {
                System.out.println("- " + enrollment.getCourse());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static void listStudentsOfCourse() {
        int courseId = UiInputUtils.readInt("Enter course ID");

        try {
            Course course = courseRepository.get(courseId);
            Set<Enrollment> enrollments = course.getEnrollments();
            System.out.println(course.getName() + " - Enrolled Students:");
            for (Enrollment enrollment : enrollments) {
                System.out.println("- " + enrollment.getStudent());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}