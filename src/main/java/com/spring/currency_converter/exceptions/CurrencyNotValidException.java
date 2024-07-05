package com.spring.currency_converter.exceptions;

public class CurrencyNotValidException extends RuntimeException{
    
    public CurrencyNotValidException(){
        super("Simbolo monetário inválido.");
    }
}