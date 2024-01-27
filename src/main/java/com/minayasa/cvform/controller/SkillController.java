package com.minayasa.cvform.controller;

import com.minayasa.cvform.dto.GeneralProfileCodeResponse;
import com.minayasa.cvform.dto.ProfileCodeResponse;
import com.minayasa.cvform.dto.SkillDataResponse;
import com.minayasa.cvform.dto.SkillDto;
import com.minayasa.cvform.service.SkillService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/skill")
public class SkillController {

    private SkillService skillService;

    @PostMapping
    public ResponseEntity<GeneralProfileCodeResponse> addSkill(@RequestBody SkillDto skillDto) {
        return ResponseEntity.ok(skillService.addSkill(skillDto));
    }

    @GetMapping
    public ResponseEntity<SkillDataResponse> getSkill() {
        return ResponseEntity.ok(skillService.getSkill());
    }

    @DeleteMapping
    public ResponseEntity<ProfileCodeResponse> deleteSkill(@RequestParam(name = "id") Long id) {
        ProfileCodeResponse profileCodeResponse = skillService.deleteSkill(id);
        return ResponseEntity.ok(profileCodeResponse);
    }

}
