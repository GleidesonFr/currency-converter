package com.spring.currency_converter.exceptions;

public class HistoryNotFoundException extends RuntimeException{
    
    public HistoryNotFoundException(){
        super("Histórico deste dado não foi encontrado.");
    }
}
