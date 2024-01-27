package com.minayasa.cvform.service.impl;

import com.minayasa.cvform.dto.ExperienceDto;
import com.minayasa.cvform.dto.ExperienceResponse;
import com.minayasa.cvform.entity.Experience;
import com.minayasa.cvform.entity.User;
import com.minayasa.cvform.exception.CvApiException;
import com.minayasa.cvform.exception.GlobalExceptionHandler;
import com.minayasa.cvform.repository.ExperienceRepository;
import com.minayasa.cvform.service.ExperienceService;
import com.minayasa.cvform.util.CurrentUser;
import lombok.AllArgsConstructor;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private ExperienceRepository experienceRepository;
    private CurrentUser currentUser;

    @Override
    @Transactional
    public ExperienceDto addExperience(ExperienceDto experienceDto) {
        try {
            User user = currentUser.getCurrentUser();
            Experience experience = Experience.builder()
                    .workingExperience(experienceDto.getWorkingExperience())
                    .build();
            experience.setUser(user);
            Experience savedExperience = experienceRepository.save(experience);
            BeanUtils.copyProperties(savedExperience, experienceDto);
            return experienceDto;
        } catch (Exception e) {
            throw new CvApiException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @Override
    public ExperienceResponse getExperience() {
        User user = currentUser.getCurrentUser();
        Experience experience = experienceRepository.fetchExperienceByUser(user);
        return ExperienceResponse.builder()
                .workingExperience(experience.getWorkingExperience())
                .build();
    }

    @Override
    @Transactional
    public ExperienceResponse updateExperience(ExperienceDto experienceDto) {
        try {
            User user = currentUser.getCurrentUser();
            Experience experience = experienceRepository.fetchExperienceByUser(user);
            experience.setWorkingExperience(experienceDto.getWorkingExperience());
            Experience updatedExperience = experienceRepository.save(experience);
            return ExperienceResponse.builder()
                    .workingExperience(updatedExperience.getWorkingExperience())
                    .build();
        } catch (Exception exception) {
            throw new CvApiException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
}
