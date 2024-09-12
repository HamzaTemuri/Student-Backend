package com.example.studentbackend.exception;

public class CourseNotFoundException extends AppException{
    public CourseNotFoundException(String message) {
        super(message);
    }
}
