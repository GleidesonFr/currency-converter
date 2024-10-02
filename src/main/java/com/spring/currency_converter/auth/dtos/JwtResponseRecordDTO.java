package com.spring.currency_converter.auth.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record JwtResponseRecordDTO(@NotEmpty String accessToken) {
    
}
