package com.todddemone.studentapp.service;

import com.todddemone.studentapp.domain.*;
import com.todddemone.studentapp.repository.Repository;
import com.todddemone.studentapp.domain.Enrollment;
import com.todddemone.studentapp.repository.EnrollmentRepository;

public class EnrollmentService {
    
    private final EnrollmentRepository enrollmentRepository;
    private final Repository<Course> courseRepository;
    private final Repository<Student> studentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, Repository<Course> courseRepository, Repository<Student> studentRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public void add(Integer courseId, Integer studentId) {
        System.out.println("Adding an enrollment...");
        Course course = courseRepository.get(courseId);
        Student student = studentRepository.get(studentId);
        enrollmentRepository.add(new Enrollment(course, student));
    }

    public void addGrade(Integer courseId, Integer studentId, Integer grade) {
        System.out.println("Adding a grade...");
        Enrollment enrollment = enrollmentRepository.get(courseId, studentId);
        enrollment.setGrade(grade);
    }
}
