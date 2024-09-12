package com.example.studentbackend.controller;

import com.example.studentbackend.domain.dto.LoginReqDto;
import com.example.studentbackend.domain.dto.LoginResDto;
import com.example.studentbackend.domain.dto.RegisterStudentDto;
import com.example.studentbackend.domain.dto.StudentResDto;
import com.example.studentbackend.domain.entity.Student;
import com.example.studentbackend.service.AuthenticationService;
import com.example.studentbackend.utilities.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtUtility jwtUtility;
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(JwtUtility jwtUtility, AuthenticationService authenticationService) {
        this.jwtUtility = jwtUtility;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<StudentResDto> register(@RequestBody RegisterStudentDto registerStudentDto) {
        return ResponseEntity.ok(authenticationService.signup(registerStudentDto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResDto> authenticate(@RequestBody LoginReqDto loginReqDto) {
        Student authenticatedStudent = authenticationService.authenticate(loginReqDto);

        String jwtToken = jwtUtility.generateToken(authenticatedStudent);

        LoginResDto loginResponse = new LoginResDto(authenticatedStudent.getEmail(), jwtToken, jwtUtility.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
