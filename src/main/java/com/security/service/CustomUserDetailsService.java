package com.security.service;

import com.security.entity.MyUser;
import com.security.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("========== LOGIN START ==========");
        System.out.println("Username received: " + username);

        MyUser user=userRepo.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User not Found."));

        System.out.println("User found: " + user.getUsername());
        System.out.println("Password from DB: " + user.getPassword());

        user.getRoles().forEach(role ->
                System.out.println("Role from DB: " + role.getRoleName())
        );

        return new User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                user.getRoles().stream()
                        .map(role->new SimpleGrantedAuthority("ROLE_"+role.getRoleName())).toList()
        );
    }
}
