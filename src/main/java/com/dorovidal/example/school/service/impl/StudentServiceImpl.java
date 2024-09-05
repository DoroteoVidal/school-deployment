package com.dorovidal.example.school.service.impl;

import com.dorovidal.example.school.model.Student;
import com.dorovidal.example.school.repository.StudentRepository;
import com.dorovidal.example.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student, Long id) {
        Student dbStudent = studentRepository.findById(id).get();

        dbStudent.setName(student.getName());
        dbStudent.setLastname(student.getLastname());
        dbStudent.setAge(student.getAge());
        dbStudent.setGenre(student.getGenre());
        dbStudent.setDni(student.getDni());

        return studentRepository.save(dbStudent);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
