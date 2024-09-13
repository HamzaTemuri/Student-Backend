package com.example.studentbackend.service;

import com.example.studentbackend.domain.dto.*;
import com.example.studentbackend.domain.entity.Application;
import com.example.studentbackend.domain.entity.Course;
import com.example.studentbackend.domain.entity.Student;
import com.example.studentbackend.exception.ApplicationNotFoundException;
import com.example.studentbackend.exception.CourseNotFoundException;
import com.example.studentbackend.exception.StudentNotFoundException;
import com.example.studentbackend.repository.ApplicationRepository;
import com.example.studentbackend.repository.CourseRepository;
import com.example.studentbackend.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    ModelMapper modelMapper;
    ApplicationRepository applicationRepository;
    StudentRepository studentRepository;
    CourseRepository courseRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository,
                                  StudentRepository studentRepository,
                                  CourseRepository courseRepository,
                                  ModelMapper modelMapper) {
        this.applicationRepository = applicationRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentApplicationResDto> getApplications(String studentEmail) {
        Student student = studentRepository.findByEmail(studentEmail)
                .orElseThrow(() -> new StudentNotFoundException("Invalid Email Address"));

        List<Application> applications = student.getApplications();

        return applications.stream().map(app -> modelMapper.map(app, StudentApplicationResDto.class)).toList();
    }

    @Override
    @Transactional
    public ApplicationResDto createApplication(ApplicationCreateReqDto applicationCreateReqDto) {
        Student student = studentRepository.findByEmail(applicationCreateReqDto.getStudentEmail())
                .orElseThrow(() -> new StudentNotFoundException("Invalid Email Address"));

        Course course = courseRepository.findById(applicationCreateReqDto.getCourseId())
                .orElseThrow(() -> new CourseNotFoundException("Invalid Course Id"));

        Application application = create(applicationCreateReqDto.getApplicationName(),student, course);

        return convertToDto(application);
    }

    @Transactional
    public Application create(String applicationName, Student student, Course course) {
        Application application = new Application();
        application.setApplicationDate(LocalDateTime.now());
        application.setName(applicationName);
        application.setStudent(student);
        application.setCourse(course);
        application.setCreatedAt(LocalDateTime.now());

        return applicationRepository.save(application);
    }

    @Override
    @Transactional
    public ApplicationResDto updateApplication(ApplicationUpdateReqDto applicationUpdateReqDto) {
        Application application = applicationRepository.findById(applicationUpdateReqDto.getApplicationId())
                .orElseThrow(() -> new ApplicationNotFoundException("Invalid Application Id"));

        Student student = studentRepository.findByEmail(applicationUpdateReqDto.getStudentEmail())
                .orElseThrow(() -> new StudentNotFoundException("Invalid Email Address"));

        Course course = courseRepository.findById(applicationUpdateReqDto.getCourseId())
                .orElseThrow(() -> new CourseNotFoundException("Invalid Course Id"));

        application = update(application, applicationUpdateReqDto.getApplicationName(), applicationUpdateReqDto.getApplicationDate(), student, course);

        return convertToDto(application);
    }

    @Transactional
    public Application update(Application application, String name, LocalDateTime applicationDate, Student student, Course course) {
        application.setName(name);
        application.setApplicationDate(applicationDate);
        application.setStudent(student);
        application.setCourse(course);
        application.setModifiedAt(LocalDateTime.now());
        return applicationRepository.save(application);
    }

    @Override
    public void deleteApplication(Long applicationId) {
        applicationRepository.deleteById(applicationId);
    }

    @Override
    public List<CourseResDto> getCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(this::convertToDto).toList();
    }

    private CourseResDto convertToDto(Course course) {
        return modelMapper.map(course, CourseResDto.class);
    }
    private ApplicationResDto convertToDto(Application application) {
        return modelMapper.map(application, ApplicationResDto.class);
    }
}
