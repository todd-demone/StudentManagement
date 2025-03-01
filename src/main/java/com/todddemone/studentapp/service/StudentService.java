package com.todddemone.studentapp.service;

import java.util.Set;
import com.todddemone.studentapp.repository.EnrollmentRepository;
import com.todddemone.studentapp.repository.Repository;
import com.todddemone.studentapp.domain.Student;
import com.todddemone.studentapp.domain.Enrollment;

public class StudentService {
    private final Repository<Student> studentRepository;
    private final EnrollmentRepository enrollmentRepository;

    public StudentService(Repository<Student> studentRepository, EnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public void add(String name) {
        Student student = new Student(name);
        studentRepository.add(student);
    }

    public Set<Enrollment> getEnrollments(Integer studentId) {
        System.out.println("Getting enrollments for student ID " + studentId + "...");
        return enrollmentRepository.getByStudentId(studentId);
    }
}
