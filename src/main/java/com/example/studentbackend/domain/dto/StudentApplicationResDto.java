package com.example.studentbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentApplicationResDto {
    private Long id;
    private String name;
    private LocalDateTime applicationDate;
    private CourseResDto course;
}
