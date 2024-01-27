package com.minayasa.cvform.controller;

import com.minayasa.cvform.dto.ExperienceDto;
import com.minayasa.cvform.dto.ExperienceResponse;
import com.minayasa.cvform.service.ExperienceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/working-experience")
public class ExperienceController {

    private ExperienceService experienceService;

    @PostMapping
    public ResponseEntity<ExperienceDto> addExperience(@RequestBody ExperienceDto experienceDto) {
        ExperienceDto savedExperience = experienceService.addExperience(experienceDto);
        return new ResponseEntity<>(savedExperience, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ExperienceResponse> getExperience() {
        return ResponseEntity.ok(experienceService.getExperience());
    }

    @PutMapping
    public ResponseEntity<ExperienceResponse> updateExperience(@RequestBody ExperienceDto experienceDto) {
        return ResponseEntity.ok(experienceService.updateExperience(experienceDto));
    }
}
