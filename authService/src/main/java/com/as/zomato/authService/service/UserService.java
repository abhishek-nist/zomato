package com.as.zomato.authService.service;

import com.as.zomato.authService.dto.*;

public interface UserService {

    UserDto signup(UserSignupDto userSignupDto);
    UserDto login(UserLoginDto userLoginDto);
}
