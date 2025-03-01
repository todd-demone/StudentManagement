package com.todddemone.studentapp.service;

import java.util.Set;
import com.todddemone.studentapp.repository.Repository;
import com.todddemone.studentapp.repository.EnrollmentRepository;
import com.todddemone.studentapp.domain.Course;
import com.todddemone.studentapp.domain.Enrollment;

public class CourseService {

    private final Repository<Course> courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public CourseService(Repository<Course> courseRepository, EnrollmentRepository enrollmentRepository) {
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public void add(String name, String courseCode) {
        System.out.println("Adding a course");
        Course course = new Course(name, courseCode);
        courseRepository.add(course);
    }

    public void remove(Integer id) {
        System.out.println("Removing course with ID " + id + "...");
        courseRepository.remove(id);
    }

    public void update(Integer id, String name, int teacherId, String courseCode) {
        System.out.println("Updating course with ID " + id + "...");
        Course course = courseRepository.get(id);
        if (course != null) {
            course.setName(name);
            course.setTeacherId(teacherId);
            course.setCourseCode(courseCode);
        } else {
            throw new IllegalArgumentException("Course not found for the given ID.");
        }
    }

    public void addTeacher(Integer courseId, Integer teacherId) {
        System.out.println("Adding teacher with ID " + teacherId + " to course with ID " + courseId + "...");
        Course course = courseRepository.get(courseId);
        if (course != null) {
            course.setTeacherId(teacherId);
        } else {
            throw new IllegalArgumentException("Course not found for the given ID.");
        }
    }

    public Set<Enrollment> getEnrollments(Integer courseId) {
        System.out.println("Getting enrollments for course ID " + courseId + "...");
        return enrollmentRepository.getByCourseId(courseId);
    }
}
