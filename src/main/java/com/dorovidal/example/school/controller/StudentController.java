package com.dorovidal.example.school.controller;

import com.dorovidal.example.school.model.Student;
import com.dorovidal.example.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(student));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.update(student, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
