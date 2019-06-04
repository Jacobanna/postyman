package com.jp.postyman.service;

import com.jp.postyman.domain.User;
import com.jp.postyman.mapper.UserMapper;
import com.jp.postyman.model.UserDto;
import com.jp.postyman.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userMapper = UserMapper.INSTANCE;
    }

    @Override
    public UserDto getUserById(int id) {
        return userRepository.findById(id)
                .map(userMapper::userToUserDto)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
    }

    //TODO zmien na findByNameAndEmail
    //TODO implement exceptions for name/email already used
    @Override
    public UserDto createUser(UserDto userDto) {
        List<UserDto> allUsers = getAllUsers();
        for (UserDto existingUser: allUsers) {
            if(userDto.getName().equals(existingUser.getName())) {
                System.out.println("Name already used.");
                return null;
            } else if (userDto.getEmail().equals(existingUser.getEmail())) {
                System.out.println("Email already used.");
                return null;
            }
        }
        return saveAndReturnUserDto(userMapper.userDtoToUser(userDto));
    }


    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    private UserDto saveAndReturnUserDto(User user) {
        User savedUser = userRepository.save(user);
        return userMapper.userToUserDto(savedUser);
    }
}
