package com.demo2.service;


import com.demo2.mapper.UserMapper;
import com.demo2.model.dto.response.UserResponse;
import com.demo2.model.entity.User;
import com.demo2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository ;

    public List<UserResponse> getAllUser(){
        return userRepository.showUsers()
                .stream()
                .map(user -> UserMapper.toUserResponse(user))
                .toList();
    }
}
