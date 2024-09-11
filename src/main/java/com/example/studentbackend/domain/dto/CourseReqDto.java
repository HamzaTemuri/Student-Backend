package com.example.studentbackend.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CourseReqDto {
    private Long id;
    private String name;
    private UniversityResDto university;
    private List<ApplicationReqDto> applications;
}
