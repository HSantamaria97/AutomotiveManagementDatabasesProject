package com.databases.project.AutoServiceManagerAPI.controller;

import com.databases.project.AutoServiceManagerAPI.Entity.Role;
import com.databases.project.AutoServiceManagerAPI.Entity.User;
import com.databases.project.AutoServiceManagerAPI.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;
import java.util.*;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
//    @GetMapping("/admin/userbyrole")
//    public ResponseEntity<List<User>> getUserbyRole(String role)
//    {
//        return ResponseEntity.ok(userRepository.getUserByRole(role));
//    }
    @GetMapping("/admin/userbyusername")
    public ResponseEntity<User> getUserByUsername(String username)
    {
        return ResponseEntity.ok(userRepository.getUserByUsername(username));
    }
    @GetMapping("/admin/getuserbyid")
    public ResponseEntity<User> getUserById(int id){
        return ResponseEntity.ok(userRepository.getUserById(id));
    }

    @PostMapping("/admin/newuser")
    public ResponseEntity<String> newUser( @Pattern(regexp = "^(.+)@(\\S+)$") String email,
                                          String firstName,
                                          String lastName,
                                          String username,
                                          String password,
                                          String phoneNumber,
                                          String role)
    {
        User user = User.builder()
                        .email(email)
                        .firstName(firstName)
                        .lastName(lastName)
                        .username(username)
                        .password(new BCryptPasswordEncoder().encode(password))
                        .phoneNumber(phoneNumber)
                        .role(Role.builder().roleName(role).build())
                        .build();
        userRepository.save(user);

        return ResponseEntity.ok("User created successfully!");
    }
}
