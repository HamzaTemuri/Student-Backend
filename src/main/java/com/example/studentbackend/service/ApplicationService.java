package com.example.studentbackend.service;

import com.example.studentbackend.domain.dto.ApplicationCreateReqDto;
import com.example.studentbackend.domain.dto.ApplicationResDto;
import com.example.studentbackend.domain.dto.ApplicationUpdateReqDto;
import com.example.studentbackend.domain.dto.CourseResDto;

import java.util.List;

public interface ApplicationService {
    List<ApplicationResDto> getApplications();
    ApplicationResDto createApplication(ApplicationCreateReqDto applicationCreateReqDto);
    ApplicationResDto updateApplication(ApplicationUpdateReqDto applicationUpdateReqDto);
    void deleteApplication(Long applicationId);
    List<CourseResDto> getCourses();
}
