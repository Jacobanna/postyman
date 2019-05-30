package com.jp.postyman.controller;

import com.jp.postyman.model.UserDto;
import com.jp.postyman.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest {

    public static final String NAME = "Martha";
    public static final int USER_ID = 1;
    public static final String EMAIL = "martha@email.com";
    public static final String PASSWORD = "koos";
    public static final String PHOTO_URL = "www.example/1.jpg";
    public static final LocalDate DATE_JOINED = LocalDate.now();
    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    MockMvc mockMvc;

    //TODO need to add exception handling later, see -> spring5-mvc-rest (CustomerControllerTest)
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }


    @Test
    public void getAllUsers() throws Exception {
        UserDto userDto1 = new UserDto();
        userDto1.setUserId(1);
        userDto1.setName("Adam");
        userDto1.setEmail("adam@email.com");
        userDto1.setPassword("pow1");
        userDto1.setProfilePhotoUrl("www.example/1.jpg");
        userDto1.setDateJoined(LocalDate.now());

        UserDto userDto2 = new UserDto();
        userDto2.setUserId(2);
        userDto2.setName("Max");
        userDto2.setEmail("max@email.com");
        userDto2.setPassword("djskw");
        userDto2.setProfilePhotoUrl("www.example/2.jpg");
        userDto2.setDateJoined(LocalDate.now());

        UserDto userDto3 = new UserDto();
        userDto3.setUserId(3);
        userDto3.setName("David");
        userDto3.setEmail("david@email.com");
        userDto3.setPassword("jrkekew");
        userDto3.setProfilePhotoUrl("www.example/3.jpg");
        userDto3.setDateJoined(LocalDate.now());

        List<UserDto> userDtoList = Arrays.asList(userDto1, userDto2, userDto3);
        when(userService.getAllUsers()).thenReturn(userDtoList);

        mockMvc.perform(get(UserController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.users", hasSize(3)));
    }

    @Test
    public void getUserById() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUserId(USER_ID);
        userDto.setName(NAME);
        userDto.setEmail(EMAIL);
        userDto.setPassword(PASSWORD);
        userDto.setProfilePhotoUrl(PHOTO_URL);
        userDto.setDateJoined(DATE_JOINED);

        when(userService.getUserById(USER_ID)).thenReturn(userDto);

        //TODO czy powinienem w JSONie zwracać userId czy user_id?
        mockMvc.perform(get(UserController.BASE_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId", equalTo(USER_ID)))
                .andExpect(jsonPath("$.name", equalTo(NAME)))
                .andExpect(jsonPath("$.email", equalTo(EMAIL)))
                .andExpect(jsonPath("$.password", equalTo(PASSWORD)))
                .andExpect(jsonPath("$.profilePhotoUrl", equalTo(PHOTO_URL)));
        //TODO error z konwersją, mogę coś z tym zrobić? Nie mam za bardzo pomysłu jak to zrobić "ładnie"
//                .andExpect(jsonPath("$.dateJoined", equalTo(DATE_JOINED)));
    }
}