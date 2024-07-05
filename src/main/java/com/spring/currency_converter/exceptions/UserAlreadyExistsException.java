package com.spring.currency_converter.exceptions;

public class UserAlreadyExistsException extends RuntimeException{
    
    public UserAlreadyExistsException(){
        super("Usuário já existe.");
    }
}
