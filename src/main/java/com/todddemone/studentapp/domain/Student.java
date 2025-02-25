package com.todddemone.studentapp.domain;

import com.todddemone.studentapp.utils.ValidationUtils;

public class Student implements Identifiable {

    private Integer id;
    private String name;
    private final int NAME_MAX_CHARACTERS = 50;

    public Student(Integer id, String name) {
        // id validation
        this.id = ValidationUtils.requireNonNull(id, "Student ID");
        this.id = ValidationUtils.requireNonNegative(this.id, "Student ID");

        // name validation
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

    @Override
    public String toString() {
        return String.format("%s (ID: %d)", name, id);
    }
}
