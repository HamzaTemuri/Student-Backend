package com.example.studentbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationCreateReqDto {
    private String applicationName;
    private String studentEmail;
    private Long courseId;
}
