package com.minayasa.cvform.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ProfileResponse {
    private Long profileCode;
    private String wantedJobTitle;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String country;
    private String city;
    private String address;
    private Integer postalCode;
    private String drivingLicence;
    private String nationality;
    private String placeOfBird;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateOfBirth;
    private String photoUrl;
}
