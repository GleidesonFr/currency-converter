package com.spring.currency_converter.controllers;

import java.util.UUID;

import javax.money.MonetaryAmount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.currency_converter.dtos.MonetaryRecordDTO;

import com.spring.currency_converter.services.MonetaryServiceImpl;

import jakarta.validation.Valid;

@RestController
public class MonetaryController {
    
    @Autowired
    MonetaryServiceImpl monetaryServiceImpl;
    
    @GetMapping("/{id}/in/currency-converter")
    public ResponseEntity<MonetaryAmount> getMonetary(@PathVariable("id") UUID id, @RequestBody @Valid MonetaryRecordDTO monetaryRecordDTO){
        MonetaryAmount monetaryAmount = monetaryServiceImpl.convertMoney(monetaryRecordDTO.from_currency_symbol(), monetaryRecordDTO.from_currency_value(), monetaryRecordDTO.to_currency_symbol(), monetaryRecordDTO.to_currency_value());
        return ResponseEntity.status(HttpStatus.OK).body(monetaryAmount);
    }
}
