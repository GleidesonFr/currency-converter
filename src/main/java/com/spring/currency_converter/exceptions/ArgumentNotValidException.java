package com.spring.currency_converter.exceptions;

public class ArgumentNotValidException extends RuntimeException{
    
    public ArgumentNotValidException(){
        super("Os dados inseridos são inválidos.");
    }
}
