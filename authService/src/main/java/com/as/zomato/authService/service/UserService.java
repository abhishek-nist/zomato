package com.as.zomato.authService.service;

import com.as.zomato.authService.dto.UserDto;
import com.as.zomato.authService.dto.UserLoginDto;
import com.as.zomato.authService.dto.UserSignupDto;

public interface UserService {

    UserDto signup(UserSignupDto userSignupDto);
    UserDto login(UserLoginDto userLoginDto);
}
