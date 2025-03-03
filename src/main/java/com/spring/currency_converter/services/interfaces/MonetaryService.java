package com.spring.currency_converter.services.interfaces;

import java.io.IOException;

public interface MonetaryService {
    
    public double convertMoney(String fromCurrency,String toCurrency, double fromValue) throws IOException;

}
