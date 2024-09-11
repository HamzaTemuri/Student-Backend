package com.example.studentbackend.service;

import com.example.studentbackend.domain.dto.UniversityReqDto;
import com.example.studentbackend.domain.dto.UniversityResDto;

import java.util.List;

public interface UniversityService {
    List<UniversityResDto> getUniversities();
    UniversityResDto getUniversity(String studentId);
    UniversityResDto createUniversity(UniversityReqDto universityReqDto);
    UniversityResDto updateUniversity(UniversityReqDto universityReqDto);
    UniversityResDto deleteUniversity(String studentId);
}
