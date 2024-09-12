package com.example.studentbackend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name="ST_APPLICATION")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STAP_ID")
    private Long id;

    @Column(name = "STAP_NAME", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "STST_ID", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "STCO_ID", nullable = false)
    private Course course;

    @Column(name = "STAP_APPLICATION_DATE", nullable = false)
    private LocalDateTime applicationDate;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "MODIFIED_AT")
    private LocalDateTime modifiedAt;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
}
