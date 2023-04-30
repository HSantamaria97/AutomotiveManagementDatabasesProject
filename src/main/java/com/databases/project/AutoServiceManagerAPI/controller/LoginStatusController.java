package com.databases.project.AutoServiceManagerAPI.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginStatusController {
    @GetMapping("/")
    public ResponseEntity<String> getLoginStatus()
    {
        return ResponseEntity.ok("Login Successful!");
    }
}
