package com.minayasa.cvform.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SkillDto {
    private Long id;
    private String skill;
    private String level;
}
