package com.spring.currency_converter.auth.controller;

import org.springframework.web.bind.annotation.RestController;

import com.spring.currency_converter.auth.dtos.AuthRequestRecordDTO;
import com.spring.currency_converter.auth.dtos.JwtResponseRecordDTO;
import com.spring.currency_converter.auth.services.JwtService;
import com.spring.currency_converter.exceptions.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;
    
    @PostMapping("/api/v1/login")
    public JwtResponseRecordDTO login(@RequestBody AuthRequestRecordDTO authRequestRecordDTO) {
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestRecordDTO.username(), authRequestRecordDTO.password()));

        if(authentication.isAuthenticated()){
            return JwtResponseRecordDTO.builder().accessToken(jwtService.generateToken(authRequestRecordDTO.username())).build();
        }else{
            throw new UserNotFoundException();
        }
    }
    
}
