package com.spring.currency_converter.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.currency_converter.dtos.LoginRecordDTO;
import com.spring.currency_converter.dtos.UserRecordDTO;
import com.spring.currency_converter.models.UserModel;
import com.spring.currency_converter.services.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
public class UserController {
    
    @Autowired
    UserServiceImpl userServiceImpl;
    
    @PostMapping("/sign-in")
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserRecordDTO userRecordDTO){
        userServiceImpl.createUser(userRecordDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created");
    }

    @GetMapping("/sign-up")
    public ResponseEntity<Object> getUser(@RequestBody @Valid LoginRecordDTO loginRecordDTO){
        UserModel user = userServiceImpl.getUser(loginRecordDTO.username(), loginRecordDTO.password());
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/{id}/in/delete-account")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") UUID id, @RequestBody @Valid LoginRecordDTO loginRecordDTO){
        userServiceImpl.deleteUser(loginRecordDTO.username(), loginRecordDTO.password());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }

    @PutMapping("/{id}/in/update-account")
    public ResponseEntity<Object> updateUser(@PathVariable("id") UUID id, @RequestBody @Valid UserRecordDTO userRecordDTO){
        UserModel user = userServiceImpl.updateUser(id, userRecordDTO);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
