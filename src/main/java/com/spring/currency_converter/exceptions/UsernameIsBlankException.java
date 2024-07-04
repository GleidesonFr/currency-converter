package com.spring.currency_converter.exceptions;

public class UsernameIsBlankException extends RuntimeException{
    
    public UsernameIsBlankException(){
        super("O nome de usuário está em branco.");
    }
}
