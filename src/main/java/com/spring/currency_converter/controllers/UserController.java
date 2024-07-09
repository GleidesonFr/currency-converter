package com.spring.currency_converter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.currency_converter.dtos.UserRecordDTO;
import com.spring.currency_converter.services.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
public class UserController {
    
    @Autowired
    UserServiceImpl userServiceImpl;
    
    @PostMapping("/sign-up")
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserRecordDTO userRecordDTO){
        userServiceImpl.createUser(userRecordDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created");
    }

    @GetMapping("/login")
    public ResponseEntity<Object> getUser(String username, String password){
        
    }
}
