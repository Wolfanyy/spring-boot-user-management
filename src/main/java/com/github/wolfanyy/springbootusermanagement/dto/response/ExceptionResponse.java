package com.github.wolfanyy.springbootusermanagement.dto.response;

import java.time.LocalDateTime;

public record ExceptionResponse(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path
) {
}
