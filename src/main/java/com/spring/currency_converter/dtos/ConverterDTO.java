package com.spring.currency_converter.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record ConverterDTO(@NotEmpty String fromCurrency, @NotEmpty String toCurrency, @Min(value = 0) Double fromValue) {
    
}
