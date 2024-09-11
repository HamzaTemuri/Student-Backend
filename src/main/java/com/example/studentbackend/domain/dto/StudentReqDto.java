package com.example.studentbackend.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class StudentReqDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private LocalDateTime enrollmentDate;
    private List<ApplicationReqDto> applications;
}
