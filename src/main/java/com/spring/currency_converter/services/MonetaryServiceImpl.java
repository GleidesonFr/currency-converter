package com.spring.currency_converter.services;

import java.io.IOException;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;

import org.javamoney.moneta.Money;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.spring.currency_converter.services.interfaces.MonetaryService;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class MonetaryServiceImpl implements MonetaryService{

    @Override
    @Async
    public double convertMoney(String from_currency, double from_value, String to_currency) throws IOException {
        String url = "https://v6.exchangerate-api.com/v6/6e5d22ca299f10ea5369030d/pair/" + from_currency + "/" + to_currency + "/" + from_value;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).get().build();

        Response response = client.newCall(request).execute();
        String stringResponse = response.body().string();
        JSONObject jsonObject = new JSONObject(stringResponse);
        System.out.println(jsonObject.toString());
        double result = jsonObject.getDouble("conversion_result");
        
        return result;
    }
}