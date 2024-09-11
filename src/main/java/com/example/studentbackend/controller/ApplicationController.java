package com.example.studentbackend.controller;

import com.example.studentbackend.domain.dto.ApplicationReqDto;
import com.example.studentbackend.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public ResponseEntity<ApplicationReqDto> getApplication() {
        return ResponseEntity.ok(new ApplicationReqDto());
    }

    @PostMapping
    public ResponseEntity<ApplicationReqDto> createApplication() {
        return ResponseEntity.ok(new ApplicationReqDto());
    }

    @PutMapping
    public ResponseEntity<ApplicationReqDto> updateApplication() {
        return ResponseEntity.ok(new ApplicationReqDto());
    }

    @DeleteMapping
    public ResponseEntity<ApplicationReqDto> deleteApplication() {
        return ResponseEntity.ok(new ApplicationReqDto());
    }
}
