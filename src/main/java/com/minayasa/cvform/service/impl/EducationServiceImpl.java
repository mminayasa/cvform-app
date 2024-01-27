package com.minayasa.cvform.service.impl;

import com.minayasa.cvform.dto.EducationDataResponse;
import com.minayasa.cvform.dto.EducationDto;
import com.minayasa.cvform.dto.GeneralProfileCodeResponse;
import com.minayasa.cvform.dto.ProfileCodeResponse;
import com.minayasa.cvform.entity.Education;
import com.minayasa.cvform.entity.User;
import com.minayasa.cvform.exception.CvApiException;
import com.minayasa.cvform.repository.EducationRepository;
import com.minayasa.cvform.repository.UserRepository;
import com.minayasa.cvform.service.EducationService;
import com.minayasa.cvform.util.CurrentUser;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EducationServiceImpl implements EducationService {

    private EducationRepository educationRepository;
    private CurrentUser currentUser;
    private UserRepository userRepository;

    @Override
    @Transactional
    public GeneralProfileCodeResponse addEducation(EducationDto educationDto) {
        try {
            User user = currentUser.getCurrentUser();
            Education education = mapToEducation(educationDto);
            education.setUser(user);
            Education savedEducation =  educationRepository.save(education);
            return GeneralProfileCodeResponse.builder().profileCode(user.getId()).id(savedEducation.getId()).build();
        } catch (Exception exception) {
            throw new CvApiException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @Override
    public EducationDataResponse getEducation() {
        User user = currentUser.getCurrentUser();
        Set<Education> educations = user.getEducations();
        List<EducationDto> educationDtos = educations.stream().map(this::mapToEducationDto).collect(Collectors.toList());
        return EducationDataResponse.builder().data(educationDtos).build();
    }

    @Override
    public ProfileCodeResponse deleteEmployment(Long id) {
        User user = currentUser.getCurrentUser();
        user.getEducations().removeIf(u -> Objects.equals(u.getId(), id));
        userRepository.save(user);
        return ProfileCodeResponse.builder().profileCode(user.getId()).build();
    }

    private Education mapToEducation(EducationDto educationDto) {
        return Education.builder()
                .id(educationDto.getId())
                .school(educationDto.getSchool())
                .degree(educationDto.getDegree())
                .startDate(educationDto.getStartDate())
                .endDate(educationDto.getEndDate())
                .city(educationDto.getCity())
                .description(educationDto.getDescription())
                .build();
    }

    private EducationDto mapToEducationDto(Education education) {
        return EducationDto.builder()
                .id(education.getId())
                .school(education.getSchool())
                .degree(education.getDegree())
                .startDate(education.getStartDate())
                .endDate(education.getEndDate())
                .city(education.getCity())
                .description(education.getDescription())
                .build();
    }
}
