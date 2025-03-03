package com.spring.currency_converter.controllers;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.currency_converter.dtos.ConverterDTO;
import com.spring.currency_converter.services.MonetaryServiceImpl;
import com.spring.currency_converter.services.interfaces.MonetaryService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class ConverterController {

    private MonetaryService monetaryService = new MonetaryServiceImpl();

    @PostMapping("api/currency/")
    public ResponseEntity<Double> convertCurrency(@RequestBody ConverterDTO converterDTO) throws IOException{
        double result = monetaryService.convertMoney(converterDTO.fromCurrency(),converterDTO.toCurrency(), converterDTO.fromValue());
        
        return ResponseEntity.ok().body(result);
    }
}
