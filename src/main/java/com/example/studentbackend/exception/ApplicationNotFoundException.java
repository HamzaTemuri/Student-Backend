package com.example.studentbackend.exception;

public class ApplicationNotFoundException extends AppException{
    public ApplicationNotFoundException(String message) {
        super(message);
    }
}
