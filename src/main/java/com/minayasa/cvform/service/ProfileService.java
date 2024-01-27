package com.minayasa.cvform.service;

import com.minayasa.cvform.dto.ProfileDto;
import com.minayasa.cvform.dto.ProfileResponse;
import com.minayasa.cvform.entity.User;

public interface ProfileService {
    User addProfile(ProfileDto profileDto);
    ProfileResponse getProfile();
    User updateProfile(ProfileDto profileDto);
}
