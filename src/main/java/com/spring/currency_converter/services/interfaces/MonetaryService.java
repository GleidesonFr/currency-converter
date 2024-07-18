package com.spring.currency_converter.services.interfaces;

import java.io.IOException;

public interface MonetaryService {
    
    public double convertMoney(String from_currency, double from_value, String to_currency) throws IOException;

}
