package com.minayasa.cvform.controller;

import com.minayasa.cvform.dto.EducationDataResponse;
import com.minayasa.cvform.dto.EducationDto;
import com.minayasa.cvform.dto.GeneralProfileCodeResponse;
import com.minayasa.cvform.dto.ProfileCodeResponse;
import com.minayasa.cvform.service.EducationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/education")
public class EducationController {

    private EducationService educationService;

    @PostMapping
    public ResponseEntity<GeneralProfileCodeResponse> addEducation(@RequestBody EducationDto educationDto) {
        return ResponseEntity.ok(educationService.addEducation(educationDto));
    }

    @GetMapping
    public ResponseEntity<EducationDataResponse> getEducation() {
        return ResponseEntity.ok(educationService.getEducation());
    }

    @DeleteMapping
    public ResponseEntity<ProfileCodeResponse> deleteEmployer(@RequestParam(name = "id") Long id) {
        ProfileCodeResponse profileCodeResponse = educationService.deleteEmployment(id);
        return ResponseEntity.ok(profileCodeResponse);

    }
}
