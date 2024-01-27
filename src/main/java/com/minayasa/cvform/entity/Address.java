package com.minayasa.cvform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String city;
    private String address;
    private Integer postalCode;
    @Column(name = "driving_license")
    private String drivingLicense;
    private String nationality;

    @Column(name = "place_of_birth")
    private String placeOfBirth;
    private Date dateOfBirth;
    @OneToOne(mappedBy = "address")
    private User user;
}
