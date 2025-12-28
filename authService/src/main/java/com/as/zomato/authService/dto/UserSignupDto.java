package com.as.zomato.authService.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserSignupDto {

    @NotBlank(message = "username is required")
    private String userName;

    @NotBlank(message = "password is required")
    private String password;

    @Email(message = "invalid email format")
    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "firstname is required")
    private String firstName;

    private String middleName;

    private String lastName;

    @NotNull(message = "mobile number is required")
    private Long mobileNumber;

}
