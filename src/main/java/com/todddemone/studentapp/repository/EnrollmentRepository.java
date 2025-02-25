package com.todddemone.studentapp.repository;

import java.util.Map;
import java.util.HashMap;
import com.todddemone.studentapp.domain.*;

public class EnrollmentRepository {
	private Map<EnrollmentKey, Enrollment> enrollments = new HashMap<>();

	public void addEnrollment(Enrollment enrollment) {
		EnrollmentKey key = new EnrollmentKey(
				enrollment.getStudent().getId(),
				enrollment.getCourse().getId());
		enrollments.put(key, enrollment);
		enrollment.getCourse().addEnrollment(enrollment);
		enrollment.getStudent().addEnrollment(enrollment);
	}

	public Enrollment getEnrollment(Integer courseId, Integer studentId) {
		return enrollments.get(new EnrollmentKey(courseId, studentId));
	}

	public Map<EnrollmentKey, Enrollment> getEnrollments() {
		return new HashMap<>(enrollments);
	}

}
