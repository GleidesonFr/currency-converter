package com.spring.currency_converter.exceptions;

public class UsernameNotValidException extends RuntimeException{
    
    public UsernameNotValidException(){
        super("O nome de usuário está em branco.");
    }
}
