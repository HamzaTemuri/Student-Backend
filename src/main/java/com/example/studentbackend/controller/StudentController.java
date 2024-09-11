package com.example.studentbackend.controller;

import com.example.studentbackend.domain.dto.StudentResDto;
import com.example.studentbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<StudentResDto> getUser() {
        return ResponseEntity.ok(new StudentResDto());
    }

    @PostMapping
    public ResponseEntity<StudentResDto> createUser() {
        return ResponseEntity.ok(new StudentResDto());
    }

    @PutMapping
    public ResponseEntity<StudentResDto> updateUser() {
        return ResponseEntity.ok(new StudentResDto());
    }

    @DeleteMapping
    public ResponseEntity<StudentResDto> deleteUser() {
        return ResponseEntity.ok(new StudentResDto());
    }
}
