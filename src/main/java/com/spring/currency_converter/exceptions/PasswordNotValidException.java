package com.spring.currency_converter.exceptions;

public class PasswordNotValidException extends RuntimeException{
    
    public PasswordNotValidException(){
        super("Senha muito curta.");
    }
}
