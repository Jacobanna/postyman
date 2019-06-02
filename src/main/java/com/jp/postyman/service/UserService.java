package com.jp.postyman.service;

import com.jp.postyman.model.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(int id);
    UserDto createUser(UserDto userDto);
    void deleteUserById(int id);
}
