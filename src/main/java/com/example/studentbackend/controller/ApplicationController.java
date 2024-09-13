package com.example.studentbackend.controller;

import com.example.studentbackend.domain.dto.*;
import com.example.studentbackend.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public ResponseEntity<List<StudentApplicationResDto>> getStudentApplications(@RequestParam String studentEmail) {
        return ResponseEntity.ok(applicationService.getApplications(studentEmail));
    }

    @PostMapping
    public ResponseEntity<ApplicationResDto> createApplication(@RequestBody ApplicationCreateReqDto applicationCreateReqDto) {
        return ResponseEntity.ok(applicationService.createApplication(applicationCreateReqDto));
    }

    @PutMapping
    public ResponseEntity<ApplicationResDto> updateApplication(@RequestBody ApplicationUpdateReqDto applicationUpdateReqDto) {
        return ResponseEntity.ok(applicationService.updateApplication(applicationUpdateReqDto));
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteApplication(@RequestParam Long applicationId) {
        applicationService.deleteApplication(applicationId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseResDto>> getCourses() {
        return ResponseEntity.ok(applicationService.getCourses());
    }
}
