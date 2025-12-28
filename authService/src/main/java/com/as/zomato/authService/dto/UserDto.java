package com.as.zomato.authService.dto;

import com.as.zomato.authService.entity.RoleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

    private String userName;

    private String email;

    private String firstName;

    private String middleName;

    private String lastName;

    private Long mobileNumber;

    private Set<RoleType> roles;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
