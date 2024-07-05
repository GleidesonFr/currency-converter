package com.spring.currency_converter.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public record APIError(@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss") LocalDateTime timestamp, Integer code, String status, List<String> errors) {
    
}
