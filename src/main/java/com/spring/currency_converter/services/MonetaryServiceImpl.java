package com.spring.currency_converter.services;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.spring.currency_converter.services.interfaces.MonetaryService;

import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class MonetaryServiceImpl implements MonetaryService{

    @Override
    @Async
    public double convertMoney(String from_currency, double from_value, String to_currency) throws IOException {

        Dotenv dotenv = Dotenv.configure().load();

        String url = "https://v6.exchangerate-api.com/v6/" + dotenv.get("API_KEY") +"/pair/" + from_currency + "/" + to_currency + "/" + from_value;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).get().build();

        Response response = client.newCall(request).execute();
        String stringResponse = response.body().string();
        JSONObject jsonObject = new JSONObject(stringResponse);
        JSONObject conversionRatesObject = jsonObject.getJSONObject("conversion_rates");
        double result = conversionRatesObject.getDouble("conversion_result");
        
        return result;
    }
}