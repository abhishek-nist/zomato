package com.as.zomato.authService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(
        name = "users",
        indexes = {
                @Index(name = "idx_user_username", columnList = "user_name"),
                @Index(name = "idx_user_email", columnList = "email"),
                @Index(name = "idx_user_mobile", columnList = "mobile_number")
        },
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "user_name"),
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "mobile_number")
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String userName;

    @Column( nullable = false)
    private String email;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    private String lastName;

    @Column( nullable = false)
    private String mobileNumber;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Roles> roles = new HashSet<>();

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
