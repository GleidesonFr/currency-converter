package com.spring.currency_converter.exceptions;

public class UserNotFoundException extends RuntimeException{
    
    public UserNotFoundException(){
        super("Usuário não encontrado.");
    }
}
