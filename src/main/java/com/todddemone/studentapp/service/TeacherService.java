package com.todddemone.studentapp.service;

import com.todddemone.studentapp.repository.Repository;
import com.todddemone.studentapp.domain.Teacher;

public class TeacherService {
    private final Repository<Teacher> teacherRepository;

    public TeacherService(Repository<Teacher> teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void add(Integer id, String name) {
        System.out.println("Adding a teacher...");
        teacherRepository.add(new Teacher(id, name));
    }
    public Teacher get(Integer id) {
        return teacherRepository.get(id);
    }
}
