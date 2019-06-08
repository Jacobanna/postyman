package com.jp.postyman.controller;

import com.jp.postyman.domain.User;
import com.jp.postyman.model.PostDto;
import com.jp.postyman.service.PostService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PostControllerTest {

    private static final Long POST_ID = 1L;
    private static final String CONTENT = "See this!";
    private static final String GRAPHIC_URL = "www.example/3.jpg";
    private static final LocalDateTime DATE_POSTED = LocalDateTime.now();

    @Mock
    PostService postService;

    @InjectMocks
    PostController postController;

    MockMvc mockMvc;

    //TODO need to add exception handling later, see -> spring5-mvc-rest (CustomerControllerTest)
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
    }

    //TODO implement
    @Test
    public void getAllPostsByUser() throws Exception {

    }

    @Test
    public void getPostById() throws Exception {
        User user = new User();
        PostDto postDto = new PostDto();
        postDto.setPostId(POST_ID);
        postDto.setContent(CONTENT);
        postDto.setGraphicUrl(GRAPHIC_URL);
        postDto.setAuthor(user);
        postDto.setDatePosted(DATE_POSTED);

        when(postService.getPostById(POST_ID)).thenReturn(postDto);

        //TODO czy powinienem w JSONie zwracać postId czy post_id?
        mockMvc.perform(get(PostController.BASE_URL + "/posts/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.postId", equalTo(1)))
                .andExpect(jsonPath("$.content", equalTo(CONTENT)))
                .andExpect(jsonPath("$.graphicUrl", equalTo(GRAPHIC_URL)))
                .andExpect(jsonPath("$.author.userId", equalTo(user.getUserId())));
                //TODO error z konwersją, mogę coś z tym zrobić? Nie mam za bardzo pomysłu jak to zrobić "ładnie"
//                .andExpect(jsonPath("$.datePosted", equalTo(DATE_POSTED)));
    }
}
