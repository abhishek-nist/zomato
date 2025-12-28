package com.as.zomato.authService.repository;

import com.as.zomato.authService.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {
}
