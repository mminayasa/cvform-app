package com.minayasa.cvform.service.impl;

import com.minayasa.cvform.dto.*;
import com.minayasa.cvform.entity.Education;
import com.minayasa.cvform.entity.Skill;
import com.minayasa.cvform.entity.User;
import com.minayasa.cvform.exception.CvApiException;
import com.minayasa.cvform.repository.SkillRepository;
import com.minayasa.cvform.repository.UserRepository;
import com.minayasa.cvform.service.SkillService;
import com.minayasa.cvform.util.CurrentUser;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SkillServiceImpl implements SkillService {

    private SkillRepository skillRepository;
    private UserRepository userRepository;
    private CurrentUser currentUser;
    @Override
    @Transactional
    public GeneralProfileCodeResponse addSkill(SkillDto skillDto) {
        try {
            User user = currentUser.getCurrentUser();
            Skill skill = mapToSkill(skillDto);
            skill.setUser(user);
            Skill savedSkill =  skillRepository.save(skill);
            return GeneralProfileCodeResponse.builder().profileCode(user.getId()).id(savedSkill.getId()).build();
        } catch (Exception exception) {
            throw new CvApiException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @Override
    public SkillDataResponse getSkill() {
        User user = currentUser.getCurrentUser();
        Set<Skill> skills = user.getSkills();
        List<SkillDto> skillDtos = skills.stream().map(this::mapToSkillDto).collect(Collectors.toList());
        return SkillDataResponse.builder().data(skillDtos).build();
    }

    @Override
    public ProfileCodeResponse deleteSkill(Long id) {
        User user = currentUser.getCurrentUser();
        user.getSkills().removeIf(u -> Objects.equals(u.getId(), id));
        userRepository.save(user);
        return ProfileCodeResponse.builder().profileCode(user.getId()).build();
    }

    private Skill mapToSkill(SkillDto skillDto) {
        return Skill.builder().skill(skillDto.getSkill()).level(skillDto.getLevel()).build();
    }

    private SkillDto mapToSkillDto(Skill skill) {
        return SkillDto.builder().id(skill.getId()).skill(skill.getSkill()).level(skill.getLevel()).build();
    }
}
