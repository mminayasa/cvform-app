package com.minayasa.cvform.service;

import com.minayasa.cvform.dto.LoginDto;
import com.minayasa.cvform.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);
}
