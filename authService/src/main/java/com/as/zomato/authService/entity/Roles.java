package com.as.zomato.authService.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private RoleType role;

    @OneToOne(mappedBy = "roles")
    private User user;

}
