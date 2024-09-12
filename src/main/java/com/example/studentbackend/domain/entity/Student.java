package com.example.studentbackend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="ST_STUDENT")
public class Student implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STST_ID")
    private Long id;

    @Column(name = "STST_NAME", nullable = false)
    private String name;

    @Column(name = "STST_EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "STST_PASSWORD", nullable = false)
    private String password;

    @Column(name = "STST_DOB", nullable = false)
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
