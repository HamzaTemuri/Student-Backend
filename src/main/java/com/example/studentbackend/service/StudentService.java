package com.example.studentbackend.service;

import com.example.studentbackend.domain.dto.StudentReqDto;
import com.example.studentbackend.domain.dto.StudentResDto;

public interface StudentService {
    public StudentResDto getStudent(StudentReqDto studentReqDto);
    public StudentResDto createStudent(StudentReqDto studentReqDto);
    public StudentResDto updateStudent(StudentReqDto studentReqDto);
    public StudentResDto deleteStudent(StudentReqDto studentReqDto);
}
