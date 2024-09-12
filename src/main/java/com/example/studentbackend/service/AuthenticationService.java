package com.example.studentbackend.service;

import com.example.studentbackend.domain.dto.LoginReqDto;
import com.example.studentbackend.domain.dto.RegisterStudentDto;
import com.example.studentbackend.domain.entity.Student;
import com.example.studentbackend.repository.StudentRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthenticationService {
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            StudentRepository studentRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Student signup(RegisterStudentDto input) {
        Student student = new Student();
        student.setName(input.getName());
        student.setEmail(input.getEmail());
        student.setPassword(passwordEncoder.encode(input.getPassword()));
        student.setDateOfBirth(input.getDateOfBirth());
        student.setEnrollmentDate(input.getEnrollmentDate());
        student.setCreatedAt(LocalDateTime.now());

        return studentRepository.save(student);
    }

    public Student authenticate(LoginReqDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return studentRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
