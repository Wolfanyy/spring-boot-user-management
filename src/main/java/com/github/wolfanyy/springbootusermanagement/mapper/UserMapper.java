package com.github.wolfanyy.springbootusermanagement.mapper;

import com.github.wolfanyy.springbootusermanagement.dto.request.UserRequest;
import com.github.wolfanyy.springbootusermanagement.dto.response.UserResponse;
import com.github.wolfanyy.springbootusermanagement.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toResponse(User user);

    List<UserResponse> toResponse(List<User> users);

    User toEntity(UserRequest request);
}