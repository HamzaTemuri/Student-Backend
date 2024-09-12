package com.example.studentbackend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="ST_UNIVERSITY")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUN_ID")
    private Long id;

    @Column(name = "STUN_NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "STUN_CITY", nullable = false)
    private String City;

    @OneToMany(mappedBy = "university", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Course> courses;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "MODIFIED_AT")
    private LocalDateTime modifiedAt;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
}
