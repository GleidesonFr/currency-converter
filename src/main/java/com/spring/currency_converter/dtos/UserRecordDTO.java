package com.spring.currency_converter.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRecordDTO(@NotBlank String name, @Size(min = 8) String password) {
    
}
