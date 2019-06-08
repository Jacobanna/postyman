package com.jp.postyman.service;

import com.jp.postyman.model.UserDto;

import java.util.List;

public interface UserService {
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto createUser(UserDto userDto);
    void deleteUserById(Long id);
}
