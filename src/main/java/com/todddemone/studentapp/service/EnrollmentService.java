package com.todddemone.studentapp.service;

import com.todddemone.studentapp.domain.Enrollment;
import com.todddemone.studentapp.domain.Course;
import com.todddemone.studentapp.domain.Student;
import com.todddemone.studentapp.repository.EnrollmentRepository;
import com.todddemone.studentapp.repository.Repository;

public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final Repository<Course> courseRepository;
    private final Repository<Student> studentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, Repository<Course> courseRepository, Repository<Student> studentRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public void add(int courseId, int studentId) {
        Enrollment enrollment = new Enrollment(courseId, studentId);
        enrollmentRepository.add(enrollment);
    }

    public void addGrade(int id, int grade) {
        Enrollment enrollment = enrollmentRepository.get(id);
        if (enrollment != null) {
            enrollment.setGrade(grade);
        } else {
            throw new IllegalArgumentException("Enrollment not found for the given course and student IDs.");
        }
    }

    public Course getCourse(int courseId) {
        return courseRepository.get(courseId);
    }

    public Student getStudent(int studentId) {
        return studentRepository.get(studentId);
    }
}
