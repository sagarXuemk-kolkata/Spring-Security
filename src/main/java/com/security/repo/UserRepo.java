package com.security.repo;

import com.security.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<MyUser, String> {
    // return the whole MyUser class to return type will be MyUser not String
    Optional<MyUser> findByUsername(String username);
}