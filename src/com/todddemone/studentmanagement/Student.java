package com.todddemone.studentmanagement;

import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

import java.util.Set;

public class Student implements Identifiable {

	private final Integer id;
    private final String name;
    private Set<Enrollment> enrollments = new HashSet<>();

    public Student(Integer id, String name) {
        Objects.requireNonNull(name, "Student name cannot be null.");
        Objects.requireNonNull(id, "Student ID cannot be null.");

        name = name.trim();

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }
        if (name.length() > 50) {
            throw new IllegalArgumentException("Student name must be 50 characters or less.");
        }
        if (!name.matches("^[A-Za-z'\\- ]+$")) {
            throw new IllegalArgumentException("Student name can only contain letters, spaces, hyphens and apostrophes.");
        }

        if (id <= 0) {
            throw new IllegalArgumentException("Student ID must be a positive number.");
        }
        String idString = String.valueOf(id);
        if (!idString.matches("^\\d{9}$")) {
            throw new IllegalArgumentException("Student ID must be exactly 9 digits (e.g., '123456789').");
        }

        this.id = id;
        this.name = name;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public Set<Enrollment> getEnrollments() { return new HashSet<>(enrollments); }

    public void addEnrollment(Enrollment enrollment) {
        if (!enrollments.add(enrollment)) {
            throw new IllegalArgumentException("This enrollment already exists.");
        }
    }

    @Override
    public String toString() {
        return String.format("%s (ID: %d) - enrolled in %d courses.", name, id, enrollments.size());
    }
}
