package com.spring.currency_converter.services.interfaces;

import javax.money.MonetaryAmount;

public interface MonetaryService {
    
    public MonetaryAmount convertMoney(String from_currency, double from_value, String to_currency, double to_value);

}
