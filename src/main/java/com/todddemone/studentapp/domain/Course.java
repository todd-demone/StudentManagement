package com.todddemone.studentapp.domain;

import com.todddemone.studentapp.utils.ValidationUtils;

public class Course implements Identifiable {
    private Integer id;
    private String name;
    private Teacher teacher;
    private String courseCode;
    private final int NAME_MAX_CHARACTERS = 100;

    public Course(Integer id, String name, Teacher teacher, String courseCode) {
        // id validation
        this.id = ValidationUtils.requireNonNull(id, "Course ID");
        this.id = ValidationUtils.requireNonNegative(this.id, "Course id");

        // name validation
        this.name = ValidationUtils.requireNonNull(name, "Course name");
        this.name = ValidationUtils.requireNonEmpty(this.name, "Course name");
        this.name = this.name.trim();
        this.name = ValidationUtils.requireCharacterLimit(this.name, NAME_MAX_CHARACTERS, "Course name");
        this.name = ValidationUtils.limitCharCategories(this.name);

        // Teacher validation
        this.teacher = ValidationUtils.requireNonNull(teacher, "Teacher");

        // courseCode validation
        this.courseCode = ValidationUtils.requireNonNull(courseCode, "Course code");
        this.courseCode = ValidationUtils.requireNonEmpty(this.courseCode, "Course code");
        this.courseCode = this.courseCode.trim().toUpperCase();

        if (!courseCode.matches("^[A-Za-z]{3}\\d{3}$")) {
            throw new IllegalArgumentException(
                    "Course code must be exactly 6 characters; first 3 letters, last 3 digits (e.g., CSC101).");
        }
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public String getCourseCode() {
        return courseCode;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, courseCode);
    }
}
