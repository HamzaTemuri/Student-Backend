package com.example.studentbackend.controller;

import com.example.studentbackend.domain.dto.UniversityResDto;
import com.example.studentbackend.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/university")
public class UniversityController {
    private UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public ResponseEntity<UniversityResDto> getUniversity() {
        return ResponseEntity.ok(new UniversityResDto());
    }

    @PostMapping
    public ResponseEntity<UniversityResDto> createUniversity() {
        return ResponseEntity.ok(new UniversityResDto());
    }

    @PutMapping
    public ResponseEntity<UniversityResDto> updateUniversity() {
        return ResponseEntity.ok(new UniversityResDto());
    }

    @DeleteMapping
    public ResponseEntity<UniversityResDto> deleteUniversity() {
        return ResponseEntity.ok(new UniversityResDto());
    }
}
