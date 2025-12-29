package com.as.zomato.authService.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size(min = 5, max = 20, message = "username must be between 5 and 20 characters")
    private String userName;

    @NotBlank(message = "password is required")
    @Size(min = 5, max = 16, message = "Password must be between 8 and 16 characters")
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
