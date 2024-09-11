package com.example.studentbackend.controller;

import com.example.studentbackend.domain.dto.CourseResDto;
import com.example.studentbackend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<CourseResDto> getCourse() {
        return ResponseEntity.ok(new CourseResDto());
    }

    @PostMapping
    public ResponseEntity<CourseResDto> createCourse() {
        return ResponseEntity.ok(new CourseResDto());
    }

    @PutMapping
    public ResponseEntity<CourseResDto> updateCourse() {
        return ResponseEntity.ok(new CourseResDto());
    }

    @DeleteMapping
    public ResponseEntity<CourseResDto> deleteCourse() {
        return ResponseEntity.ok(new CourseResDto());
    }
}
