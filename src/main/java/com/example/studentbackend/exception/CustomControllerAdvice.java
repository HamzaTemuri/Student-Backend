package com.example.studentbackend.exception;

import com.example.studentbackend.domain.dto.ErrorResDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ApplicationNotFoundException.class, StudentNotFoundException.class, CourseNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request) {
        ErrorResDto errorResDto = new ErrorResDto(HttpStatus.NOT_FOUND, ex.getMessage());
        return createResponseEntity(errorResDto, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(StudentAlreadyExistException.class)
    protected ResponseEntity<Object> handleAlreadyExist(Exception ex, WebRequest request) {
        ErrorResDto errorResDto = new ErrorResDto(HttpStatus.CONFLICT, ex.getMessage());
        return createResponseEntity(errorResDto, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(AuthenticationException.class)
    protected ResponseEntity<Object> handleAuthenticationFail(Exception ex, WebRequest request) {
        ErrorResDto errorResDto = new ErrorResDto(HttpStatus.UNAUTHORIZED, ex.getMessage());
        return createResponseEntity(errorResDto, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @ExceptionHandler(TokenVerificationFailedException.class)
    protected ResponseEntity<Object> handleTokenVerificationFailed(Exception ex, WebRequest request) {
        ErrorResDto errorResDto = new ErrorResDto(HttpStatus.UNAUTHORIZED, ex.getMessage());
        return createResponseEntity(errorResDto, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest request) {
        ErrorResDto errorResDto = new ErrorResDto(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected Error Occurred...");
        return createResponseEntity(errorResDto, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
