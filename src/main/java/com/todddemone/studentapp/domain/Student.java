package com.todddemone.studentapp.domain;

import com.todddemone.studentapp.utils.IdGenerator;
import com.todddemone.studentapp.utils.ValidationUtils;

public class Student implements Identifiable {

    private final int id;
    private final String name;
    private final int NAME_MAX_CHARACTERS = 50;

    public Student(String name) {
        this.id = IdGenerator.generateStudentId();

        // Validate name
        String validatedName = ValidationUtils.requireNonNull(name, "Student name");
        validatedName = ValidationUtils.requireNonEmpty(validatedName, "Student name");
        validatedName = validatedName.trim();
        validatedName = ValidationUtils.requireCharacterLimit(validatedName, NAME_MAX_CHARACTERS, "Student name");
        validatedName = ValidationUtils.limitCharCategories(validatedName);
        this.name = validatedName;
    }

    public int getId() {
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
