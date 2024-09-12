package com.example.studentbackend.service;

import com.example.studentbackend.domain.dto.LoginReqDto;
import com.example.studentbackend.domain.dto.RegisterStudentDto;
import com.example.studentbackend.domain.dto.StudentResDto;
import com.example.studentbackend.domain.entity.Student;
import com.example.studentbackend.exception.StudentAlreadyExistException;
import com.example.studentbackend.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthenticationServiceImpl(
            StudentRepository studentRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            ModelMapper modelMapper
    ) {
        this.authenticationManager = authenticationManager;
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public StudentResDto signup(RegisterStudentDto input) {
        Optional<Student> byEmail = studentRepository.findByEmail(input.getEmail());
        if (byEmail.isPresent()) {
            throw new StudentAlreadyExistException("Email Already Exist");
        }

        Student student = new Student();
        student.setName(input.getName());
        student.setEmail(input.getEmail());
        student.setPassword(passwordEncoder.encode(input.getPassword()));
        student.setDateOfBirth(input.getDateOfBirth());
        student.setEnrollmentDate(input.getEnrollmentDate());
        student.setCreatedAt(LocalDateTime.now());

        return convertToDto(studentRepository.save(student));
    }

    public Student authenticate(LoginReqDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword())
        );

        return studentRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }

    private StudentResDto convertToDto(Student student) {
        return modelMapper.map(student, StudentResDto.class);
    }
}
