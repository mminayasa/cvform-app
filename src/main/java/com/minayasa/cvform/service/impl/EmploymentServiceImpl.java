package com.minayasa.cvform.service.impl;

import com.minayasa.cvform.dto.EmploymentCreateResponse;
import com.minayasa.cvform.dto.EmploymentDataResponse;
import com.minayasa.cvform.dto.EmploymentDto;
import com.minayasa.cvform.dto.ProfileCodeResponse;
import com.minayasa.cvform.entity.Employment;
import com.minayasa.cvform.entity.User;
import com.minayasa.cvform.repository.EmploymentRepository;
import com.minayasa.cvform.repository.UserRepository;
import com.minayasa.cvform.service.EmploymentService;
import com.minayasa.cvform.util.CurrentUser;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Log4j2
public class EmploymentServiceImpl implements EmploymentService {
    private final UserRepository userRepository;

    private EmploymentRepository employmentRepository;
    private CurrentUser currentUser;

    @Override
    public EmploymentCreateResponse createEmployment(EmploymentDto employmentDto) {
        User user = currentUser.getCurrentUser();
        Employment employment = mapToEmployment(employmentDto);
        employment.setUser(user);
        Employment savedEmployment = employmentRepository.save(employment);
        return EmploymentCreateResponse.builder()
                .profileCode(savedEmployment.getUser().getId())
                .id(savedEmployment.getId())
                .build();
    }

    @Override
    public EmploymentDataResponse getAllEmployment() {
        User user = currentUser.getCurrentUser();
        Set<Employment> employments = user.getEmployments();
        List<EmploymentDto> employmentDtos = employments.stream().map(this::mapToEmploymentDto).collect(Collectors.toList());
        return EmploymentDataResponse.builder().data(employmentDtos).build();
    }

    @Override
    public ProfileCodeResponse deleteEmployment(Long id) {
        User user = currentUser.getCurrentUser();
        user.getEmployments().removeIf(u -> Objects.equals(u.getId(), id));
        userRepository.save(user);
        return ProfileCodeResponse.builder().profileCode(user.getId()).build();
    }

    private Employment mapToEmployment(EmploymentDto employmentDto) {
        return Employment.builder()
                .jobTitle(employmentDto.getJobTitle())
                .employer(employmentDto.getEmployer())
                .startDate(employmentDto.getStartDate())
                .endDate(employmentDto.getEndDate())
                .city(employmentDto.getCity())
                .description(employmentDto.getDescription())
                .build();
    }

    private EmploymentDto mapToEmploymentDto(Employment employment) {
        return EmploymentDto.builder()
                .id(employment.getId())
                .jobTitle(employment.getJobTitle())
                .employer(employment.getEmployer())
                .startDate(employment.getStartDate())
                .endDate(employment.getEndDate())
                .city(employment.getCity())
                .description(employment.getDescription())
                .build();
    }
}
