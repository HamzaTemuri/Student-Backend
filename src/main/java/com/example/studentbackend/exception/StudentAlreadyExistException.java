package com.example.studentbackend.exception;

public class StudentAlreadyExistException extends AppException{
    public StudentAlreadyExistException(String message) {
        super(message);
    }
}
