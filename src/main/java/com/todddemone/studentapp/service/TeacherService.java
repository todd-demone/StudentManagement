package com.todddemone.studentapp.service;

import com.todddemone.studentapp.repository.Repository;
import com.todddemone.studentapp.domain.Teacher;

public class TeacherService {
    private final Repository<Teacher> teacherRepository;

    public TeacherService(Repository<Teacher> teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void add(String name) {
        Teacher teacher = new Teacher(name);
        teacherRepository.add(teacher);
    }

    public Teacher get(Integer id) {
        return teacherRepository.get(id);
    }
}
