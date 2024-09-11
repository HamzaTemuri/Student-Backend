package com.example.studentbackend.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UniversityResDto {
    private Long id;
    private String name;
    private String City;
    private List<CourseResDto> courses;
    private List<ApplicationReqDto> applications;
}
