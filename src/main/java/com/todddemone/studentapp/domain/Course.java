package com.todddemone.studentapp.domain;

import com.todddemone.studentapp.utils.IdGenerator;
import com.todddemone.studentapp.utils.ValidationUtils;

public class Course implements Identifiable {
    private final int id;
    private String name;
    private int teacherId;
    private String courseCode;
    private final int NAME_MAX_CHARACTERS = 100;

    public Course(String name, String courseCode) {
        this.id = IdGenerator.generateCourseId();

        // Validate name
        String validatedName = ValidationUtils.requireNonNull(name, "Course name");
        validatedName = ValidationUtils.requireNonEmpty(validatedName, "Course name");
        validatedName = validatedName.trim();
        validatedName = ValidationUtils.requireCharacterLimit(validatedName, NAME_MAX_CHARACTERS, "Course name");
        validatedName = ValidationUtils.limitCharCategories(validatedName);
        this.name = validatedName;

        // Validate teacherId
        // this.teacherId = ValidationUtils.requireNonNegative(teacherId, "Teacher ID");

        // Validate courseCode
        String validatedCourseCode = ValidationUtils.requireNonNull(courseCode, "Course code");
        validatedCourseCode = ValidationUtils.requireNonEmpty(validatedCourseCode, "Course code");
        validatedCourseCode = validatedCourseCode.trim().toUpperCase();
        if (!validatedCourseCode.matches("^[A-Za-z]{3}\\d{3}$")) {
            throw new IllegalArgumentException(
                    "Course code must be exactly 6 characters; first 3 letters, last 3 digits (e.g., CSC101).");
        }
        this.courseCode = validatedCourseCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, courseCode);
    }
}
