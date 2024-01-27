package com.minayasa.cvform.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhotoDto {
    private String base64img;
    private String name;
}
