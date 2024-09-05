package com.dorovidal.example.school.service;

import com.dorovidal.example.school.model.Student;

import java.util.List;

public interface StudentService {

    Student getById(Long id);

    List<Student> getAll();

    Student save(Student student);

    Student update(Student student, Long id);

    void delete(Long id);
}
