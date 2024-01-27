package com.minayasa.cvform.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EducationDataResponse {
    List<EducationDto> data;
}
