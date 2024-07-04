package com.spring.currency_converter.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.currency_converter.repositories.UserRepository;

public class UserController {
    
    @Autowired
    UserRepository userRepository;

    
}
