package com.security.service;

import com.security.dto.UserRequest;
import com.security.entity.MyUser;
import com.security.entity.UserRole;
import com.security.repo.RoleRepo;
import com.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder encoder;

    public String saveUser(UserRequest request) {

        MyUser myUser=new MyUser();

        myUser.setUsername(request.getUsername());
        myUser.setPassword(encoder.encode(request.getPassword()));

        // set all the roles
        Set<UserRole> roles = new HashSet<>();

        for(String roleName:request.getRoles()) {
            UserRole role = roleRepo.findByRoleName(roleName)   // findByRoleName return UserRole class
                    .orElseGet(()->{
                        UserRole newRole = new UserRole();
                        newRole.setRoleName(roleName);
                        return roleRepo.save(newRole);
                    });
            role.setMyUser(myUser);
            roles.add(role);
        }
        myUser.setRoles(roles);
        userRepo.save(myUser);

        return "User save successfully";
    }
}
