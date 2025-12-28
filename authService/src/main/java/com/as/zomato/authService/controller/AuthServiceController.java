package com.as.zomato.authService.controller;

import com.as.zomato.authService.dto.UserDto;
import com.as.zomato.authService.dto.UserLoginDto;
import com.as.zomato.authService.dto.UserSignupDto;
import com.as.zomato.authService.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthServiceController {


    private final UserService userService;

    public AuthServiceController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public UserDto signup(@Valid @RequestBody UserSignupDto userSignupDto){
        return userService.signup(userSignupDto);
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody UserLoginDto userLoginDto){
        return userService.login(userLoginDto);
    }
}
