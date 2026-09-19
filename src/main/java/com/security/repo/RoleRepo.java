package com.security.repo;

import com.security.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByRoleName(String name);
}
