package com.github.wolfanyy.springbootusermanagement.controller;

import com.github.wolfanyy.springbootusermanagement.dto.request.UserRequest;
import com.github.wolfanyy.springbootusermanagement.dto.response.UserResponse;
import com.github.wolfanyy.springbootusermanagement.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponse> findAll() {
        return userService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(
            @Valid @RequestBody UserRequest request
    ) {
        return userService.create(request);
    }

}
