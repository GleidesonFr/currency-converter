package com.spring.currency_converter.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UserRecordDTO(@NotEmpty String name,@NotEmpty String email, @NotNull @Min(value = 8) String password) {
    
}
