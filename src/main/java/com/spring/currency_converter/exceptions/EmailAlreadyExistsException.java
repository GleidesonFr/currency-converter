package com.spring.currency_converter.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{
    
    public EmailAlreadyExistsException(){
        super("Este e-mail já existe.");
    }
}
