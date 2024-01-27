package com.minayasa.cvform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmploymentCreateResponse {
    private Long profileCode;
    private Long id;
}
