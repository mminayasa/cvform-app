package com.minayasa.cvform.service;

import com.minayasa.cvform.dto.EmploymentCreateResponse;
import com.minayasa.cvform.dto.EmploymentDataResponse;
import com.minayasa.cvform.dto.EmploymentDto;
import com.minayasa.cvform.dto.ProfileCodeResponse;

public interface EmploymentService {
    EmploymentCreateResponse createEmployment(EmploymentDto employmentDto);
    EmploymentDataResponse getAllEmployment();
    ProfileCodeResponse deleteEmployment(Long id);
}
