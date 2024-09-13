package com.example.studentbackend.service;

import com.example.studentbackend.domain.dto.*;

import java.util.List;

public interface ApplicationService {
    List<StudentApplicationResDto> getApplications(String studentEmail);
    ApplicationResDto createApplication(ApplicationCreateReqDto applicationCreateReqDto);
    ApplicationResDto updateApplication(ApplicationUpdateReqDto applicationUpdateReqDto);
    void deleteApplication(Long applicationId);
    List<CourseResDto> getCourses();
}
