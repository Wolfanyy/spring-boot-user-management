package com.github.wolfanyy.springbootusermanagement.service;

import com.github.wolfanyy.springbootusermanagement.dto.request.UserRequest;
import com.github.wolfanyy.springbootusermanagement.dto.response.UserResponse;
import com.github.wolfanyy.springbootusermanagement.entity.User;
import com.github.wolfanyy.springbootusermanagement.exception.DuplicateEmailException;
import com.github.wolfanyy.springbootusermanagement.exception.UserNotFoundException;
import com.github.wolfanyy.springbootusermanagement.exception.ValidationException;
import com.github.wolfanyy.springbootusermanagement.mapper.UserMapper;
import com.github.wolfanyy.springbootusermanagement.repository.UserRepository;
import com.github.wolfanyy.springbootusermanagement.util.UserNormalizer;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserNormalizer userNormalizer;

    @Override
    public UserResponse create(UserRequest request) {

        User user = userMapper.toEntity(request);

        userNormalizer.normalize(user);

        validateEmailUniqueness(user);

        User savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse findById(Long id) {

        validateId(id);

        return userMapper.toResponse(
                getUserOrThrow(id)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponse> findAll() {

        return userMapper.toResponse(
                userRepository.findAll()
        );
    }

    @Override
    public UserResponse update(
            Long id,
            UserRequest request
    ) {

        validateId(id);

        getUserOrThrow(id);

        User user = userMapper.toEntity(request);

        user.setId(id);

        userNormalizer.normalize(user);

        validateEmailUniqueness(user);

        User savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }

    @Override
    public void deleteById(Long id) {

        validateId(id);

        getUserOrThrow(id);

        userRepository.deleteById(id);
    }

    private void validateId(Long id) {

        if (id == null) {
            throw new ValidationException("User id cannot be null");
        }

        if (id <= 0) {
            throw new ValidationException("User id must be positive");
        }

    }

    private void validateEmailUniqueness(User user) {

        userRepository.findByEmail(user.getEmail())
                .ifPresent(existingUser -> {

                    boolean anotherUserWithSameEmail =
                            user.getId() == null
                                    || !existingUser.getId()
                                    .equals(user.getId());

                    if (anotherUserWithSameEmail) {
                        throw new DuplicateEmailException(user.getEmail());
                    }

                });
    }

    private User getUserOrThrow(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

    }
}
