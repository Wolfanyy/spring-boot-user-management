package com.github.wolfanyy.springbootusermanagement.dto.request;

import jakarta.validation.constraints.*;

public record UserRequest(

        @NotBlank(message = "Name cannot be empty")
        @Size(
                min = 3,
                max = 30,
                message = "Name must be between 3 and 30 characters"
        )
        @Pattern(
                regexp = "^[A-Za-zА-Яа-яЁё\\s-]+$",
                message = "Name contains invalid characters"
        )
        String name,

        @NotBlank(message = "Last name cannot be empty")
        @Size(
                min = 3,
                max = 30,
                message = "Last name must be between 3 and 30 characters"
        )
        @Pattern(
                regexp = "^[A-Za-zА-Яа-яЁё\\s-]+$",
                message = "Last name contains invalid characters"
        )
        String lastName,

        @NotBlank(message = "Email cannot be empty")
        @Size(
                max = 50,
                message = "Email must not exceed 50 characters"
        )
        @Email(message = "Email is invalid")
        String email,

        @NotNull(message = "Age cannot be null")
        @Min(
                value = 1,
                message = "Age must be between 1 and 100"
        )
        @Max(
                value = 100,
                message = "Age must be between 1 and 100"
        )
        Integer age
) {
}