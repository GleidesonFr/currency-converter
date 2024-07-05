package com.spring.currency_converter.exceptions;

public class EmailNotValidException extends RuntimeException{
    
    public EmailNotValidException(){
        super("Email inválido.");
    }
}
