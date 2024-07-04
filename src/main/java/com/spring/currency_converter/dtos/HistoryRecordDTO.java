package com.spring.currency_converter.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HistoryRecordDTO(@NotBlank String from_currency_symbol, @NotNull Long from_currency_value, @NotBlank String to_currency_symbol, @NotNull Long to_currency_value) {
    
}
