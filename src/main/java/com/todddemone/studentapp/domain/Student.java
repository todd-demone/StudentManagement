package com.todddemone.studentapp.domain;

import java.util.Set;
import java.util.HashSet;
import com.todddemone.studentapp.utils.*;

public class Student implements Identifiable {

    private Integer id;
    private String name;
    private Set<Enrollment> enrollments = new HashSet<>();
    private final int NAME_MAX_CHARACTERS = 50;

    public Student(Integer id, String name) {
        // Student ID validation
        this.id = ValidationUtils.requireNonNull(id, "Student ID");
        this.id = ValidationUtils.requireNonNegative(this.id, "Student ID");

        // Student name validation
        this.name = ValidationUtils.requireNonNull(name, "Student name");
        this.name = ValidationUtils.requireNonEmpty(this.name, "Student name");
        this.name = this.name.trim();
        this.name = ValidationUtils.requireCharacterLimit(this.name, NAME_MAX_CHARACTERS, "Course name");
        this.name = ValidationUtils.limitCharCategories(this.name);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

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
        return String.format("%s (ID: %d) - enrolled in %d courses.", name, id, enrollments.size());
    }
}
