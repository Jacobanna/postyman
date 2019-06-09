package com.jp.postyman.service;

import com.jp.postyman.model.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto patchUser(Long id, UserDto userDto);
    //TODO, może tutaj zamiast userDto powinienem już używać czegoś innego? Tylko password tu będzie można ruszać
    //UserDto changePassword(Long id, UserDto userDto);
    void deleteUserById(Long id);
}
