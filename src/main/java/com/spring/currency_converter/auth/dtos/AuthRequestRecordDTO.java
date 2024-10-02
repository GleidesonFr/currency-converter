package com.spring.currency_converter.auth.dtos;

import jakarta.validation.constraints.NotEmpty;

public record AuthRequestRecordDTO(@NotEmpty String username, @NotEmpty String password) {
}
