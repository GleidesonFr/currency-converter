package com.spring.currency_converter.exceptions;

public class ArgumentNotValidException extends RuntimeException{
    
    public ArgumentNotValidException(){
        super("nome de usuário e/ou senha são inválidos.");
    }
}
