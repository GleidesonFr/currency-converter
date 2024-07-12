package com.spring.currency_converter.services;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;

import org.springframework.stereotype.Service;

import com.spring.currency_converter.services.interfaces.MonetaryService;

@Service
public class MonetaryServiceImpl implements MonetaryService{

    @Override
    public MonetaryAmount convertMoney(String from_currency, double from_value, String to_currency, double to_value) {
        MonetaryAmount from = Monetary.getDefaultAmountFactory().setCurrency(from_currency).setNumber(from_value).create();
        CurrencyConversion to = MonetaryConversions.getConversion(to_currency);
        MonetaryAmount conversion = from.with(to);
        return conversion;
    }
    

}