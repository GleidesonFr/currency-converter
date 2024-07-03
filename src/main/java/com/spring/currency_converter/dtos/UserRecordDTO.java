package com.spring.currency_converter.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserRecordDTO(@NotBlank String name, @NotBlank String password) {
}