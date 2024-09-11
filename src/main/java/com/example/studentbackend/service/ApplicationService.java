package com.example.studentbackend.service;

import com.example.studentbackend.domain.dto.ApplicationReqDto;
import com.example.studentbackend.domain.dto.ApplicationResDto;

public interface ApplicationService {
    public ApplicationResDto getApplication(ApplicationReqDto applicationReqDto);
    public ApplicationResDto createApplication(ApplicationReqDto applicationReqDto);
    public ApplicationResDto updateApplication(ApplicationReqDto applicationReqDto);
    public ApplicationResDto deleteApplication(ApplicationReqDto applicationReqDto);
}
