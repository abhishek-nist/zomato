package com.as.zomato.authService.service.impl;

import com.as.zomato.authService.dto.UserDto;
import com.as.zomato.authService.dto.UserLoginDto;
import com.as.zomato.authService.dto.UserSignupDto;
import com.as.zomato.authService.entity.RoleType;
import com.as.zomato.authService.entity.Roles;
import com.as.zomato.authService.entity.User;
import com.as.zomato.authService.exception.InvalidCredentialsException;
import com.as.zomato.authService.exception.UserAlreadyExistsException;
import com.as.zomato.authService.exception.UserNotFoundException;
import com.as.zomato.authService.repository.UserRepository;
import com.as.zomato.authService.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto signup(UserSignupDto userSignupDto) throws UserAlreadyExistsException{

        if(userRepository.findByUserName(userSignupDto.getUserName()).isPresent()){
            throw new UserAlreadyExistsException("User with this username already exist! Try a different username");
        }
        if(userRepository.findByEmail(userSignupDto.getEmail()).isPresent()){
            throw new UserAlreadyExistsException("User with this Email already exist! Try with other Email");
        }
        if(userRepository.findByMobileNumber(userSignupDto.getMobileNumber()).isPresent()){
            throw new UserAlreadyExistsException("User with this mobile number already exist! Try another mobile number");
        }
        User user = new User();
        user.setUserName(userSignupDto.getUserName());
        user.setEmail(userSignupDto.getEmail());
        user.setFirstName(userSignupDto.getFirstName());
        user.setMiddleName(userSignupDto.getMiddleName());
        user.setLastName(userSignupDto.getLastName());
        user.setPassword(passwordEncoder.encode(userSignupDto.getPassword()));
        user.setMobileNumber(userSignupDto.getMobileNumber());
        user.setCreatedAt(LocalDateTime.now());

        Roles role = new Roles();
        role.setRole(RoleType.USER);
        role.setUser(user);

        user.getRoles().add(role);

        User savedUser = userRepository.save(user);
        return mapToUserDto(savedUser);
    }

    @Override
    public UserDto login(UserLoginDto userLoginDto) throws UserNotFoundException,InvalidCredentialsException {
        User user = userRepository.findByUserName(userLoginDto.getUserName()).orElseThrow(() -> new UserNotFoundException("Invalid username!, please check and try again."));
        if (!passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword()))
        {
            throw new InvalidCredentialsException("Invalid credential!, please try again.");
        }
        return mapToUserDto(user);
    }


    private UserDto mapToUserDto(User user) {

        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setUserName(user.getUserName());
        userDto.setMiddleName(user.getMiddleName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setMobileNumber(user.getMobileNumber());
        userDto.setCreatedAt(user.getCreatedAt());
        userDto.setUpdatedAt(user.getUpdatedAt());
        Set<RoleType> roles = user.getRoles()
                .stream()
                .map(Roles::getRole)
                .collect(Collectors.toSet());

        userDto.setRoles(roles);
        return userDto;
    }

}
