package com.databases.project.AutoServiceManagerAPI.controller;

import com.databases.project.AutoServiceManagerAPI.Entity.Role;
import com.databases.project.AutoServiceManagerAPI.Entity.User;
import com.databases.project.AutoServiceManagerAPI.Repository.UserRepository;
import com.databases.project.AutoServiceManagerAPI.Service.UserService;
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
    UserService userService;

    @GetMapping("/admin/userbyrole")
    public ResponseEntity<List<User>> getUserbyRole(String role)
    {
        return ResponseEntity.ok(userService.getUserByRole(role));
    }
    @GetMapping("/admin/userbyusername")
    public ResponseEntity<User> getUserByUsername(String username)
    {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }
    @GetMapping("/admin/getuserbyid")
    public ResponseEntity<User> getUserById(int id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/admin/newuser")
    public ResponseEntity<String> newUser(  String email,
                                            String firstName,
                                            String lastName,
                                            String username,
                                            String password,
                                            String phoneNumber,
                                            String role)
    {
        userService.createNewUser(email, firstName, lastName, username, password, phoneNumber, role);
        return ResponseEntity.ok("User created successfully!");
    }

    @PostMapping("/admin/updateUser")
    public ResponseEntity<String> updateUserInfo(long id, String firstName,
                                                  String lastName,
                                                  String username,
                                                  String password,
                                                  String email,
                                                  String phoneNumber,
                                                  String role)
    {
        userService.updateUserInfo(id,firstName,lastName,username,password,email,phoneNumber,role);
        return ResponseEntity.ok("User updated!");
    }

    @PostMapping("/admin/deleteuser")
    public ResponseEntity<String> deleteUser(long id)
    {
        userService.deleteUserById(id);
        return ResponseEntity.ok("User deleted!");
    }
}
