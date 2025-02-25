package com.todddemone.studentapp.domain;

import java.util.Objects;
import com.todddemone.studentapp.utils.ValidationUtils;

public class Enrollment {

    private Course course;
    private Student student;
    private int grade;

    public Enrollment(Course course, Student student) {
        this.course = ValidationUtils.requireNonNull(course, "Course");
        this.student = ValidationUtils.requireNonNull(student, "Student");
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

    public void setGrade(int grade) {
        this.grade = grade;
    }

    // Override equals and hashCode to compare enrollments by course and student
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
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
