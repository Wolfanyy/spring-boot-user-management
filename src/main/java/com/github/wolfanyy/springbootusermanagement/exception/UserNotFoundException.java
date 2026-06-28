package com.github.wolfanyy.springbootusermanagement.exception;

public class UserNotFoundException extends ServiceException {

    public UserNotFoundException(Long id) {
        super("User with id %d not found".formatted(id));
    }
}
