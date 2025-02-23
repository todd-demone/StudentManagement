package com.todddemone.studentmanagement;

import java.util.Objects;

public class Enrollment {

    private Course course;
    private Student student;
    private int grade;

    public Enrollment( Course course, Student student) {
        if (course == null) {
        	throw new IllegalArgumentException("Course cannot be null.");
        }
        if (student == null) {
        	throw new IllegalArgumentException("Student cannot be null.");
        }

        this.course = course;
        this.student = student;
    }


    public Course getCourse() {
        return course;
    }
    public Student getStudent() {
        return student;
    }
    public int getGrade() {
        return grade;
    }

    public void addGrade(int grade) {
        this.grade = grade;
    }

    // Override equals and hashCode to compare enrollments by course and student
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Enrollment that = (Enrollment) obj;
        return this.course.equals(that.course) && this.student.equals(that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, student);
    }

    @Override
    public String toString() {
        return String.format("Student: %s, Course: %s, Grade: %d%n", student, course, grade);
    }

}
