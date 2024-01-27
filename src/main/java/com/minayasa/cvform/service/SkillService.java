package com.minayasa.cvform.service;

import com.minayasa.cvform.dto.*;

public interface SkillService {
    GeneralProfileCodeResponse addSkill(SkillDto skillDto);
    SkillDataResponse getSkill();
    ProfileCodeResponse deleteSkill(Long id);
}
