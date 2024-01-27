package com.minayasa.cvform.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExperienceDto {
    private Long id;
    private String workingExperience;
}
