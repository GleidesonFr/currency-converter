package com.spring.currency_converter.controllers;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.currency_converter.dtos.ConverterDTO;
import com.spring.currency_converter.services.MonetaryServiceImpl;
import com.spring.currency_converter.services.interfaces.MonetaryService;

@RestController
public class ConverterController {

    private MonetaryService monetaryService = new MonetaryServiceImpl();

    @GetMapping("/api/currency/")
    public double convertCurrency(@RequestBody ConverterDTO converterDTO) throws IOException{
        double result = monetaryService.convertMoney(converterDTO.fromCurrency(),converterDTO.toCurrency(), converterDTO.fromValue());
        
        return result;
    }
}
