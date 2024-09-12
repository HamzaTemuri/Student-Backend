package com.example.studentbackend.controller;

import com.example.studentbackend.domain.dto.LoginReqDto;
import com.example.studentbackend.domain.dto.LoginResDto;
import com.example.studentbackend.domain.dto.RegisterStudentDto;
import com.example.studentbackend.domain.entity.Student;
import com.example.studentbackend.service.AuthenticationService;
import com.example.studentbackend.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Student> register(@RequestBody RegisterStudentDto registerStudentDto) {
        Student student = authenticationService.signup(registerStudentDto);

        return ResponseEntity.ok(student);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResDto> authenticate(@RequestBody LoginReqDto loginReqDto) {
        Student authenticatedStudent = authenticationService.authenticate(loginReqDto);

        String jwtToken = jwtService.generateToken(authenticatedStudent);

        LoginResDto loginResponse = new LoginResDto(authenticatedStudent.getEmail(), jwtToken, jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
