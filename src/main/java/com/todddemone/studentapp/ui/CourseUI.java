package com.todddemone.studentapp.ui;

import com.todddemone.studentapp.service.CourseService;
import com.todddemone.studentapp.exceptions.ValidationException;
import com.todddemone.studentapp.repository.*;
import com.todddemone.studentapp.utils.UiInputUtils;

public class CourseUI {
    private final CourseService courseService;
    private final UiInputUtils uiInputUtils;

    public CourseUI(CourseService courseService, UiInputUtils uiInputUtils) {
        this.courseService = courseService;
        this.uiInputUtils = uiInputUtils;
    }

    public void add() {
        String name = uiInputUtils.readString("Enter the course name");
        Integer teacherId = uiInputUtils.readInt("Enter teacher ID");
        String courseCode = uiInputUtils.readString("Enter the course code").trim().toUpperCase();

        try {
            courseService.add(name, teacherId, courseCode);
            System.out.println("Course added successfully");
        } catch (ValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }

    public void remove() {
        Integer courseId = uiInputUtils.readInt("Enter course ID: ");
        courseService.remove(courseId);
    }

    public void update() {
        Integer courseId = uiInputUtils.readInt("Enter course ID: ");
        String courseName = uiInputUtils.readString("Enter course name: ");
        courseService.update(courseId, courseName);
    }

    public void addTeacher() {
        Integer courseId = uiInputUtils.readInt("Enter course ID: ");
        Integer teacherId = uiInputUtils.readInt("Enter teacher ID: ");
        courseService.addTeacherToCourse(courseId, teacherId);
    }

    public String getCourseDetails() {
        Integer courseId = uiInputUtils.readInt("Enter course ID: ");
        return courseService.get(courseId).toString();
    }
}
