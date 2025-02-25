package com.todddemone.studentapp.repository;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;
import com.todddemone.studentapp.domain.Enrollment;

public class EnrollmentRepository {
	private Map<EnrollmentKey, Enrollment> records = new HashMap<>();

	public void add(Enrollment enrollment) {
		EnrollmentKey key = new EnrollmentKey(enrollment.getStudent().getId(), enrollment.getCourse().getId());
		records.put(key, enrollment);
	}

	public Enrollment get(Integer courseId, Integer studentId) {
		return records.get(new EnrollmentKey(courseId, studentId));
	}

	public void remove(Integer courseId, Integer studentId) {
		records.remove(new EnrollmentKey(courseId, studentId));
	}

	public Map<EnrollmentKey, Enrollment> getAll() {
		return new HashMap<>(records);
	}

	public Set<Enrollment> getByStudentId(Integer studentId) {
		return records.values().stream().filter(e -> e.getStudent().getId().equals(studentId))
				.collect(Collectors.toSet());
	}

	public Set<Enrollment> getByCourseId(Integer courseId) {
		return records.values().stream().filter(enrollment -> enrollment.getCourse().getId().equals(courseId))
				.collect(Collectors.toSet());
	}
}
