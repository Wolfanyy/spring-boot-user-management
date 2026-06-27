package com.github.wolfanyy.springbootusermanagement.dto.response;

public record UserResponse(
        Long id,
        String name,
        String lastName,
        String email,
        Integer age
) {
}
