package com.example.studentbackend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="ST_STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STST_ID")
    private Long id;

    @Column(name = "STST_NAME")
    private String name;

    @Column(name = "STST_EMAIL", unique = true)
    private String email;

    @Column(name = "STST_PASSWORD")
    private String password;

    @Column(name = "STST_DOB")
    private LocalDate dateOfBirth;

    @Column(name = "STST_ENROLLMENT_DATE")
    private LocalDateTime enrollmentDate;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Application> applications;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "MODIFIED_AT")
    private LocalDateTime modifiedAt;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
}
