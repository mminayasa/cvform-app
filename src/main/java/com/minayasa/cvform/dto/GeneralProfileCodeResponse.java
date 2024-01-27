package com.minayasa.cvform.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeneralProfileCodeResponse {
    private Long profileCode;
    private Long id;
}
