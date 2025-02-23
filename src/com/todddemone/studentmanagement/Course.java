package com.todddemone.studentmanagement;

import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

public class Course implements Identifiable {
	private Integer id;
    private String name;
    private Teacher teacher;
    private String courseCode;
    private Set<Enrollment> enrollments = new HashSet<>();

    public Course(Integer id, String name, String courseCode) {
        Objects.requireNonNull(name, "Course name cannot be null.");
        Objects.requireNonNull(courseCode, "Course code cannot be null.");

        name = name.trim();
        courseCode = courseCode.trim().toUpperCase();

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be empty.");
        }
        if (courseCode.isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be empty.");
        }

        if (name.length() > 100) {
            throw new IllegalArgumentException("Course name must be 100 characters or less.");
        }
        if (!courseCode.matches("^[A-Za-z]{3}\\d{3}$")) {
            throw new IllegalArgumentException("Course code must be exactly 6 characters; first 3 letters, last 3 digits (e.g., CSC101).");
        }
        
        this.id = id;
        this.name = name;
        this.courseCode = courseCode;

        enrollments = new HashSet<>();
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public Teacher getTeacher() { return teacher; }
    public String getCourseCode() { return courseCode; }
    public Set<Enrollment> getEnrollments() {
        return new HashSet<>(enrollments);
    }

    public void addEnrollment(Enrollment enrollment) {
        if (!enrollments.add(enrollment)) {
            throw new IllegalArgumentException("This enrollment already exists.");
        }
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %d students enrolled", name, courseCode, enrollments.size());
    }
}
