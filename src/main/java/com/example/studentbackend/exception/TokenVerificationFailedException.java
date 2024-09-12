package com.example.studentbackend.exception;

public class TokenVerificationFailedException extends AppException{
    public TokenVerificationFailedException(String message) {
        super(message);
    }
}
