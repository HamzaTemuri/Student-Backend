package com.example.studentbackend.service;

import com.example.studentbackend.domain.dto.LoginReqDto;
import com.example.studentbackend.domain.dto.RegisterStudentDto;
import com.example.studentbackend.domain.dto.StudentResDto;
import com.example.studentbackend.domain.entity.Student;

public interface AuthenticationService {
    StudentResDto signup(RegisterStudentDto input);
    Student authenticate(LoginReqDto input);
}
