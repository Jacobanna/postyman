package com.jp.postyman.service;

import com.jp.postyman.domain.User;
import com.jp.postyman.model.UserDto;
import com.jp.postyman.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    //TODO zrobiłem tutaj private te stałe, z automatu robią się public, dlaczego?
    private static final String NAME = "Max";
    private static final String EMAIL = "maxima@gmail.com";
    private static final String PASSWORD = "kowoiesaq1";
    private static final int USER_ID = 1;
    private static final String PHOTO_URL = "www.example/3.jpg";
    private static final LocalDate DATE_JOINED = LocalDate.now();

    UserService userService;

    @Mock
    UserRepository userRepository;

    //TODO dodać exception handling?
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void getAllUsers() {
        //Given
        List<User> users = Arrays.asList(new User(), new User(), new User());
        when(userRepository.findAll()).thenReturn(users);

        //When
        List<UserDto> userDtoList = userService.getAllUsers();

        //Then
        assertEquals(3, userDtoList.size());
    }

    @Test
    public void getUserById() {
        //Given
        User user = new User();
        user.setUserId(USER_ID);
        user.setName(NAME);
        user.setEmail(EMAIL);
        user.setPassword(PASSWORD);
        user.setProfilePhotoUrl(PHOTO_URL);
        user.setDateJoined(DATE_JOINED);
        when(userRepository.findById(USER_ID)).thenReturn(Optional.ofNullable(user));

        //When
        UserDto userDto = userService.getUserById(USER_ID);

        //Then
        assertEquals(USER_ID, userDto.getUserId());
        assertEquals(NAME, userDto.getName());
        assertEquals(EMAIL, userDto.getEmail());
        assertEquals(PASSWORD, userDto.getPassword());
        assertEquals(PHOTO_URL, userDto.getProfilePhotoUrl());
        assertEquals(DATE_JOINED, userDto.getDateJoined());
    }
}