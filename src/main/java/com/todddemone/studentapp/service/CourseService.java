package com.todddemone.studentapp.service;

import java.util.Set;
import com.todddemone.studentapp.repository.Repository;
import com.todddemone.studentapp.repository.EnrollmentRepository;
import com.todddemone.studentapp.domain.Course;
import com.todddemone.studentapp.domain.Teacher;
import com.todddemone.studentapp.domain.Enrollment;

public class CourseService {

    private final Repository<Course> courseRepository;
    private final Repository<Teacher> teacherRepository;
    private final EnrollmentRepository enrollmentRepository;

    public CourseService(Repository<Course> courseRepository, Repository<Teacher> teacherRepository,
            EnrollmentRepository enrollmentRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public void add(Integer id, String name, Integer teacherId, String courseCode) {
        System.out.println("Adding a course");
        Teacher teacher = teacherRepository.get(teacherId);
        courseRepository.add(new Course(id, name, teacher, courseCode));
    }

    public Set<Enrollment> getEnrollments(Integer courseId) {
        System.out.println("Getting enrollments for course ID " + courseId + "...");
        return enrollmentRepository.getByCourseId(courseId);
    }
}
