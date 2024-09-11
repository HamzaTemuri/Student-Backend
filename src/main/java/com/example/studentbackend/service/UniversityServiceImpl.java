package com.example.studentbackend.service;

import com.example.studentbackend.domain.dto.UniversityReqDto;
import com.example.studentbackend.domain.dto.UniversityResDto;
import com.example.studentbackend.domain.entity.University;
import com.example.studentbackend.repository.UniversityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityService {
    UniversityRepository universityRepository;
    ModelMapper modelMapper;

    @Autowired
    public UniversityServiceImpl(UniversityRepository universityRepository,
                                 ModelMapper modelMapper) {
        this.universityRepository = universityRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<UniversityResDto> getUniversities() {
        List<University> universities = universityRepository.findAll();
        return universities.stream().map(this::convertToDto).toList();
    }

    @Override
    public UniversityResDto getUniversity(String studentId) {
        University university = universityRepository.findById(Long.getLong(studentId)).orElse(null);
        return convertToDto(university);
    }

    @Override
    @Transactional
    public UniversityResDto createUniversity(UniversityReqDto universityReqDto) {
        University university = convertToEntity(universityReqDto);
        //Always creates new entity
        university.setId(null);
        Optional<University> optionalUniversity = universityRepository.findByName(university.getName());
        if (optionalUniversity.isEmpty()) {
            university = create(university);
        } else {
            //throw already exist
        }

        return convertToDto(university);
    }

    @Override
    @Transactional
    public UniversityResDto updateUniversity(UniversityReqDto universityReqDto) {
        University university = convertToEntity(universityReqDto);

        Optional<University> optionalUniversity = universityRepository.findById(universityReqDto.getId());
        if (optionalUniversity.isPresent()) {
            university = update(optionalUniversity.get(), universityReqDto);
        } else {
            university = create(university);
        }
        return convertToDto(university);
    }

    @Override
    @Transactional
    public UniversityResDto deleteUniversity(String studentId) {
        universityRepository.findById(Long.getLong(studentId)).ifPresent(university -> universityRepository.delete(university));
        return new UniversityResDto();
    }

    @Transactional
    protected University create(University university) {
        university.setCreatedAt(LocalDateTime.now());
        return universityRepository.save(university);
    }

    @Transactional
    protected University update(University university, UniversityReqDto universityReqDto) {
        university.setName(universityReqDto.getName());
        university.setCity(universityReqDto.getCity());
        university.setModifiedAt(LocalDateTime.now());
        return universityRepository.save(university);
    }

    private UniversityResDto convertToDto(University university) {
        return modelMapper.map(university, UniversityResDto.class);
    }

    private University convertToEntity(UniversityReqDto universityReqDto) {
        return modelMapper.map(universityReqDto, University.class);
    }
}
