package com.todddemone.studentapp;

import com.todddemone.studentapp.domain.Course;
import com.todddemone.studentapp.domain.Student;
import com.todddemone.studentapp.domain.Teacher;
import com.todddemone.studentapp.repository.EnrollmentRepository;
import com.todddemone.studentapp.repository.Repository;
import com.todddemone.studentapp.service.CourseService;
import com.todddemone.studentapp.service.EnrollmentService;
import com.todddemone.studentapp.service.StudentService;
import com.todddemone.studentapp.service.TeacherService;
import com.todddemone.studentapp.utils.UiInputUtils;
import com.todddemone.studentapp.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        Repository<Course> courseRepository = new Repository<>();
        Repository<Student> studentRepository = new Repository<>();
        Repository<Teacher> teacherRepository = new Repository<>();
        EnrollmentRepository enrollmentRepository = new EnrollmentRepository();

        CourseService courseService = new CourseService(courseRepository, teacherRepository, enrollmentRepository);
        StudentService studentService = new StudentService(studentRepository, enrollmentRepository);
        TeacherService teacherService = new TeacherService(teacherRepository);
        EnrollmentService enrollmentService = new EnrollmentService(enrollmentRepository, courseRepository,
                studentRepository);

        UiInputUtils uiInputUtils = new UiInputUtils();

        ConsoleUI consoleUI = new ConsoleUI(courseService, studentService, teacherService, enrollmentService,
                uiInputUtils);
        consoleUI.run();
    }
}
