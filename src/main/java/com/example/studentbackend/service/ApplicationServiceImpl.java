package com.example.studentbackend.service;

import com.example.studentbackend.domain.dto.ApplicationReqDto;
import com.example.studentbackend.domain.dto.ApplicationResDto;
import com.example.studentbackend.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public ApplicationResDto getApplication(ApplicationReqDto applicationReqDto) {
        return null;
    }

    @Override
    public ApplicationResDto createApplication(ApplicationReqDto applicationReqDto) {
        return null;
    }

    @Override
    public ApplicationResDto updateApplication(ApplicationReqDto applicationReqDto) {
        return null;
    }

    @Override
    public ApplicationResDto deleteApplication(ApplicationReqDto applicationReqDto) {
        return null;
    }
}
