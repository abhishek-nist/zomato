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

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    @Email
    private String email;

    @NotBlank
    private String firstName;

    private String middleName;

    private String lastName;

    @NotNull
    private Long mobileNumber;

}
