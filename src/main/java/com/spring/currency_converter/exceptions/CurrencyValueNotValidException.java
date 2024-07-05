package com.spring.currency_converter.exceptions;

public class CurrencyValueNotValidException extends RuntimeException{
    
    public CurrencyValueNotValidException(){
        super("Valor monetário inválido.");
    }
}
