package com.todddemone.studentmanagement;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class MainUI {
    private static final Scanner scanner = new Scanner(System.in);
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

            int choice = readInt("Enter your choice");
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
    	Integer id = readInt("Enter the course ID");
        String name = readString("Enter the course name");
        String courseCode = readString("Enter the course code").trim().toUpperCase();

        try {
            courseRepository.add(new Course(id, name, courseCode));
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addStudent() {
    	int id = readInt("Enter the student ID");
        String name = readString("Enter the student name");

        try {
            studentRepository.add(new Student(id, name));
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void addTeacher() {
    	int id = readInt("Enter the teacher ID");
        String name = readString("Enter the teacher name");

        try {
            teacherRepository.add(new Teacher(id, name));
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addEnrollment() {
        int courseId = readInt("Enter the course ID");
        int studentId = readInt("Enter the student ID");

        try {
        	Course course = courseRepository.get(courseId);
        	Student student = studentRepository.get(studentId);
            enrollmentRepository.addEnrollment(new Enrollment(course, student));
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addGrade() {
        int courseId = readInt("Enter the course ID");
        int studentId = readInt("Enter the student ID");
        int grade = readInt("Enter the grade");

        try {
            Enrollment enrollment = enrollmentRepository.getEnrollment(courseId, studentId);
            enrollment.addGrade(grade);
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listCoursesOfStudent() {
        int studentId = readInt("Enter student ID");

        try {
            Student student = studentRepository.get(studentId);
            Set<Enrollment> enrollments = student.getEnrollments();
            System.out.println(student.getName() + "'s Course List:");
            for (Enrollment enrollment : enrollments) {
                System.out.println("- " + enrollment.getCourse());
            }
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static void listStudentsOfCourse() {
        int courseId = readInt("Enter course ID");

        try {
            Course course = courseRepository.get(courseId);
            Set<Enrollment> enrollments = course.getEnrollments();
            System.out.println(course.getName() + " - Enrolled Students:");
            for (Enrollment enrollment : enrollments) {
                System.out.println("- " + enrollment.getStudent());
            }
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int readInt(String prompt) {
        int result = 0;
        while (true) {
            System.out.print(prompt + ": ");
            try {
                result = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                // If invalid input was placed in the input buffer by scanner.nextInt() (see above), we need
                // scanner.nextLine() to discard that input from the buffer. Otherwise, the input stays there and the
                // loop keeps seeing invalid input and keeps looping indefinitely.
                scanner.nextLine();
            }
        }
        return result;
    }

    private static String readString(String prompt) {
        String result = "";
        while (true) {
            System.out.print(prompt + ": ");
            try {
                result = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a string.");
                scanner.nextLine();
            }
        }
        return result;
    }
}