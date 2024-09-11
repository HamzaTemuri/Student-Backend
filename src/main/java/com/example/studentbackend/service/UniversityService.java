package com.example.studentbackend.service;

import com.example.studentbackend.domain.dto.UniversityReqDto;
import com.example.studentbackend.domain.dto.UniversityResDto;

public interface UniversityService {
    public UniversityResDto getUniversity(UniversityReqDto universityReqDto);
    public UniversityResDto createUniversity(UniversityReqDto universityReqDto);
    public UniversityResDto updateUniversity(UniversityReqDto universityReqDto);
    public UniversityResDto deleteUniversity(UniversityReqDto universityReqDto);
}
