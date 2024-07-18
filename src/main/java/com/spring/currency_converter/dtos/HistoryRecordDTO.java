package com.spring.currency_converter.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record HistoryRecordDTO(@NotEmpty String from_currency_symbol, @NotNull @Min(value = 0) double from_currency_value, @NotEmpty String to_currency_symbol, double to_currency_value) {
    
}
