package com.minayasa.cvform.service;

import com.minayasa.cvform.dto.EducationDataResponse;
import com.minayasa.cvform.dto.EducationDto;
import com.minayasa.cvform.dto.GeneralProfileCodeResponse;
import com.minayasa.cvform.dto.ProfileCodeResponse;

public interface EducationService {
    GeneralProfileCodeResponse addEducation(EducationDto educationDto);
    EducationDataResponse getEducation();

    ProfileCodeResponse deleteEmployment(Long id);
}
