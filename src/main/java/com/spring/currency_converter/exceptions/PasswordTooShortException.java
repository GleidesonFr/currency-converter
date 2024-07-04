package com.spring.currency_converter.exceptions;

public class PasswordTooShortException extends RuntimeException{
    
    public PasswordTooShortException(){
        super("Senha muito curta.");
    }
}
