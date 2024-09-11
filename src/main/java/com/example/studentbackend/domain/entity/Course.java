package com.example.studentbackend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="ST_COURSE")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STCO_ID")
    private Long id;

    @Column(name = "STCO_NAME", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "STUN_ID", nullable = false)
    private University university;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
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
