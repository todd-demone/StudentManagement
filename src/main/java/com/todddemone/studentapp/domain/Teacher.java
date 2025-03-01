package com.todddemone.studentapp.domain;

import java.util.Set;
import java.util.HashSet;
import com.todddemone.studentapp.utils.ValidationUtils;
import com.todddemone.studentapp.utils.IdGenerator;

public class Teacher implements Identifiable {
    private final int id;
    private final String name;
    private Set<Course> courses = new HashSet<>();
    private final int NAME_MAX_CHARACTERS = 50;

    public Teacher(String name) {
        this.id = IdGenerator.generateTeacherId();

        // Validate name
        String validatedName = ValidationUtils.requireNonNull(name, "Teacher name");
        validatedName = ValidationUtils.requireNonEmpty(validatedName, "Teacher name");
        validatedName = validatedName.trim();
        validatedName = ValidationUtils.requireCharacterLimit(validatedName, NAME_MAX_CHARACTERS, "Teacher name");
        validatedName = ValidationUtils.limitCharCategories(validatedName);
        this.name = validatedName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Course> getCourses() {
        return new HashSet<>(courses);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public String toString() {
        return String.format("%s (ID: %d) - teaching %d courses.", name, id, courses.size());
    }
}
