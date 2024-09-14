package com.example.studentbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationResDto {
    private Long id;
    private String name;
    private StudentResDto student;
    private CourseResDto course;
}
