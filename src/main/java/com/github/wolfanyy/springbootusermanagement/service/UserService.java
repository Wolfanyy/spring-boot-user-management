package com.github.wolfanyy.springbootusermanagement.service;

import com.github.wolfanyy.springbootusermanagement.dto.request.UserRequest;
import com.github.wolfanyy.springbootusermanagement.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse create(UserRequest request);

    UserResponse findById(Long id);

    List<UserResponse> findAll();

    UserResponse update(Long id, UserRequest request);

    void deleteById(Long id);

}
