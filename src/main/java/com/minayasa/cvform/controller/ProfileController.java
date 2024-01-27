package com.minayasa.cvform.controller;

import com.minayasa.cvform.dto.ProfileDto;
import com.minayasa.cvform.dto.ProfileResponse;
import com.minayasa.cvform.entity.User;
import com.minayasa.cvform.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@AllArgsConstructor
@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private ProfileService profileService;

    @PostMapping
    public ResponseEntity<HashMap<String, Long>> addProfile(@RequestBody ProfileDto request) {
        HashMap<String, Long> response = new HashMap<>();
        User user = profileService.addProfile(request);
        response.put("profileCode", user.getId());
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ProfileResponse> getProfile() {
        return ResponseEntity.ok(profileService.getProfile());
    }

    @PutMapping
    public ResponseEntity<?> updateProfile(@RequestBody ProfileDto profileDto) {
        HashMap<String, Long> response = new HashMap<>();
        User user = profileService.updateProfile(profileDto);
        response.put("profileCode", user.getId());
        return ResponseEntity.ok(response);

    }
}
