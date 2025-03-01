package com.todddemone.studentapp.repository;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;
import com.todddemone.studentapp.domain.Enrollment;

public class EnrollmentRepository {
	private Map<Integer, Enrollment> records = new HashMap<>();

	public void add(Enrollment enrollment) {
		records.put(enrollment.getId(), enrollment);
	}

	public Enrollment get(Integer id) {
		return records.get(id);
	}

	public void remove(Integer id) {
		records.remove(id);
	}

	public Map<Integer, Enrollment> getAll() {
		return new HashMap<>(records);
	}

	public Set<Enrollment> getByStudentId(Integer studentId) {
		return records.values().stream().filter(e -> Integer.valueOf(e.getStudentId()).equals(studentId))
				.collect(Collectors.toSet());
	}

	public Set<Enrollment> getByCourseId(Integer courseId) {
		return records.values().stream().filter(e -> Integer.valueOf(e.getCourseId()).equals(courseId))
				.collect(Collectors.toSet());
	}
}
