package com.example.studentbackend.service;

import com.example.studentbackend.domain.dto.ApplicationReqDto;
import com.example.studentbackend.domain.dto.ApplicationResDto;

public interface ApplicationService {
    ApplicationResDto getApplication(ApplicationReqDto applicationReqDto);
    ApplicationResDto createApplication(ApplicationReqDto applicationReqDto);
    ApplicationResDto updateApplication(ApplicationReqDto applicationReqDto);
    ApplicationResDto deleteApplication(ApplicationReqDto applicationReqDto);
}
