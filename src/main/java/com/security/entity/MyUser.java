package com.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyUser {
    @Id
    private String username;
    private String password;

    @OneToMany(mappedBy = "myUser", cascade = CascadeType.ALL)
    private Set<UserRole> roles;
}
