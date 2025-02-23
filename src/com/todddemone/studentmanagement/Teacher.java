package com.todddemone.studentmanagement;

import java.util.Set;
import java.util.HashSet;

public class Teacher implements Identifiable {
	private Integer id;
	private String name;
	private Set<Course> courses = new HashSet<>();
	
	public Teacher(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() { return id; }
	public String getName() { return name; }
	public Set<Course> getCourses() { return new HashSet<>(courses); }
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	
}
