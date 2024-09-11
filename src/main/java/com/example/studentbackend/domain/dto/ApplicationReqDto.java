package com.example.studentbackend.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApplicationReqDto {
    private String id;
    private String name;
    private StudentResDto user;
    private UniversityResDto university;
    private CourseResDto course;
}
