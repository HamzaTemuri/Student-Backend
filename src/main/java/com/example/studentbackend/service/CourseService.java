package com.example.studentbackend.service;

import com.example.studentbackend.domain.dto.CourseReqDto;
import com.example.studentbackend.domain.dto.CourseResDto;

public interface CourseService {
    public CourseResDto getCourse(CourseReqDto courseReqDto);
    public CourseResDto createCourse(CourseReqDto courseReqDto);
    public CourseResDto updateCourse(CourseReqDto courseReqDto);
    public CourseResDto deleteCourse(CourseReqDto courseReqDto);
}
