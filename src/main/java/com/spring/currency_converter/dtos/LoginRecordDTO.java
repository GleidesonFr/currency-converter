package com.spring.currency_converter.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record LoginRecordDTO(@NotEmpty String username, @Size(min = 8, max = 20) String password) {
    
}