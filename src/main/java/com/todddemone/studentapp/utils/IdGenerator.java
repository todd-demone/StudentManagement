package com.todddemone.studentapp.utils;

import java.util.concurrent.atomic.AtomicInteger;

public final class IdGenerator {

    private static final AtomicInteger courseIdCounter = new AtomicInteger(1);
    private static final AtomicInteger studentIdCounter = new AtomicInteger(1);
    private static final AtomicInteger teacherIdCounter = new AtomicInteger(1);
    private static final AtomicInteger enrollmentIdCounter = new AtomicInteger(1);

    private IdGenerator() {
    }

    public static int generateCourseId() {
        return courseIdCounter.getAndIncrement();
    }

    public static int generateStudentId() {
        return studentIdCounter.getAndIncrement();
    }

    public static int generateTeacherId() {
        return teacherIdCounter.getAndIncrement();
    }

    public static int generateEnrollmentId() {
        return enrollmentIdCounter.getAndIncrement();
    }
}
