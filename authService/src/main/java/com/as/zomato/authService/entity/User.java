package com.as.zomato.authService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column( nullable = false, unique = true)
    private String userName;

    @Column( nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    private String lastName;

    @Column( nullable = false, unique = true)
    private Integer mobileNumber;

    private String password;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Roles roles;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(insertable = false)
    private LocalDateTime updatedAt;

}
