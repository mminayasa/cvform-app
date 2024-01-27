package com.minayasa.cvform.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EmploymentDataResponse {
    private List<EmploymentDto> data;
}
