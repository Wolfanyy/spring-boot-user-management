package com.github.wolfanyy.springbootusermanagement.exception;

public class DuplicateEmailException extends ServiceException {

    public DuplicateEmailException(String email) {
        super("User with email '%s' already exists"
                .formatted(email));
    }
}
