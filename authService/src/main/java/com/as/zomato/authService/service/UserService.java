package com.as.zomato.authService.service;

import com.as.zomato.authService.dto.UserDto;
import com.as.zomato.authService.dto.UserLoginDto;
import com.as.zomato.authService.dto.UserSignupDto;
import com.as.zomato.authService.entity.RoleType;

import java.util.Set;

public interface UserService {

    UserDto signup(UserSignupDto userSignupDto);
    Set<RoleType> getUserRoles(Long userId);
    UserDto login(UserLoginDto userLoginDto);
}
