package com.todddemone.studentapp.repository;

import java.util.Objects;

public class EnrollmentKey {
	private Integer courseId;
	private Integer studentId;

	public EnrollmentKey(Integer courseId, Integer studentId) {
		this.courseId = courseId;
		this.studentId = studentId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof EnrollmentKey))
			return false;
		EnrollmentKey that = (EnrollmentKey) o;
		return courseId.equals(that.courseId) &&
				studentId.equals(that.studentId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseId, studentId);
	}
}
