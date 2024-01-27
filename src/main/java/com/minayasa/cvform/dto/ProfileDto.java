package com.minayasa.cvform.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProfileDto {
    private String wantedJobTitle;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String country;
    private String city;
    private String address;
    private Integer postalCode;
    private String drivingLicense;
    private String nationality;
    private String placeOfBirth;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateOfBirth;
}
