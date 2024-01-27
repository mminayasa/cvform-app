package com.minayasa.cvform.service;

import com.minayasa.cvform.dto.ExperienceDto;
import com.minayasa.cvform.dto.ExperienceResponse;

public interface ExperienceService {
    ExperienceDto addExperience(ExperienceDto experienceDto);
    ExperienceResponse getExperience();
    ExperienceResponse updateExperience(ExperienceDto experienceDto);
}
