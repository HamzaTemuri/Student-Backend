package com.example.studentbackend.controller;

import com.example.studentbackend.domain.dto.UniversityReqDto;
import com.example.studentbackend.domain.dto.UniversityResDto;
import com.example.studentbackend.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {
    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public ResponseEntity<List<UniversityResDto>> getUniversities() {
        return ResponseEntity.ok(universityService.getUniversities());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<UniversityResDto> getUniversity(@PathVariable String studentId) {
        return ResponseEntity.ok(universityService.getUniversity(studentId));
    }

    @PostMapping
    public ResponseEntity<UniversityResDto> createUniversity(@RequestBody UniversityReqDto universityReqDto) {
        return new ResponseEntity<UniversityResDto>(universityService.createUniversity(universityReqDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UniversityResDto> updateUniversity(@RequestBody UniversityReqDto universityReqDto) {
        return ResponseEntity.ok(universityService.updateUniversity(universityReqDto));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<UniversityResDto> deleteUniversity(@PathVariable String studentId) {
        return ResponseEntity.ok(universityService.deleteUniversity(studentId));
    }
}
