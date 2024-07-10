package com.spring.currency_converter.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.currency_converter.dtos.UserRecordDTO;
import com.spring.currency_converter.models.UserModel;
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
        UserModel user = userServiceImpl.getUser(username, password);
        user.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class)).withRel("User"));
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/{username}/delete-account")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") String username, String password){
        userServiceImpl.deleteUser(username, password);
        return ResponseEntity.status(HttpStatus.OK).body("Product deletec successfully");
    }

    @PutMapping("/{username}/update-account")
    public ResponseEntity<Object> updateUser(@PathVariable("username") String username, UserRecordDTO userRecordDTO){
        UserModel user = userServiceImpl.updateUser(userRecordDTO);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
