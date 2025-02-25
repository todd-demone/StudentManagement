package com.todddemone.studentapp.domain;

import java.util.Set;
import java.util.HashSet;
import com.todddemone.studentapp.utils.*;

public class Teacher implements Identifiable {
	private Integer id;
	private String name;
	private Set<Course> courses = new HashSet<>();
	private final int NAME_MAX_CHARACTERS = 50;

	public Teacher(Integer id, String name) {
		// Teacher ID validation
		this.id = ValidationUtils.requireNonNull(id, "Teacher ID");
		this.id = ValidationUtils.requireNonNegative(this.id, "Teacher ID");

		// Teacher name validation
		this.name = ValidationUtils.requireNonNull(name, "Teacher name");
		this.name = ValidationUtils.requireNonEmpty(this.name, "Teacher Name");
		this.name.trim();
		this.name = ValidationUtils.requireCharacterLimit(this.name, NAME_MAX_CHARACTERS, "Teacher name");
		this.name = ValidationUtils.limitCharCategories(this.name);
	}

	public Integer getId() {
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
