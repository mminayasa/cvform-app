package com.minayasa.cvform.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "educations")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String school;
    private String degree;
    private Date startDate;
    private Date endDate;
    private String city;
    private String description;

    @ManyToOne
    @JoinColumn
    private User user;

}
