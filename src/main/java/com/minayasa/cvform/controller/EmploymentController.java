package com.minayasa.cvform.controller;

import com.minayasa.cvform.dto.EmploymentCreateResponse;
import com.minayasa.cvform.dto.EmploymentDataResponse;
import com.minayasa.cvform.dto.EmploymentDto;
import com.minayasa.cvform.dto.ProfileCodeResponse;
import com.minayasa.cvform.entity.User;
import com.minayasa.cvform.service.EmploymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employment")
public class EmploymentController {

    private EmploymentService employmentService;

    @PostMapping
    public ResponseEntity<EmploymentCreateResponse> addEmployment(@RequestBody EmploymentDto employmentDto) {
        EmploymentCreateResponse employmentCreateResponse = employmentService.createEmployment(employmentDto);
        return ResponseEntity.ok(employmentCreateResponse);
    }

    @GetMapping
    public ResponseEntity<EmploymentDataResponse> getEmployment() {
        EmploymentDataResponse employmentDataResponse = employmentService.getAllEmployment();
        return ResponseEntity.ok(employmentDataResponse);
    }

    @DeleteMapping
    public ResponseEntity<ProfileCodeResponse> deleteEmployer(@RequestParam(name = "id") Long id) {
        ProfileCodeResponse profileCodeResponse = employmentService.deleteEmployment(id);
        return ResponseEntity.ok(profileCodeResponse);

    }
}
