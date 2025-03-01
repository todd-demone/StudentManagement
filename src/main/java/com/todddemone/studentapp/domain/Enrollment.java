package com.todddemone.studentapp.domain;

import com.todddemone.studentapp.utils.IdGenerator;
import java.util.Objects;

public class Enrollment {
    private final int id;
    private final int courseId;
    private final int studentId;
    private int grade;

    public Enrollment(int courseId, int studentId) {
        this.id = IdGenerator.generateEnrollmentId();
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public int getId() {
        return id;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Enrollment that = (Enrollment) obj;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, studentId);
    }

    @Override
    public String toString() {
        return String.format("Student ID: %d, Course ID: %d, Grade: %d%n", studentId, courseId, grade);
    }
}
