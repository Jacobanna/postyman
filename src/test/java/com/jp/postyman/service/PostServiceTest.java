package com.jp.postyman.service;

import com.jp.postyman.domain.Post;
import com.jp.postyman.domain.User;
import com.jp.postyman.model.PostDto;
import com.jp.postyman.repository.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class PostServiceTest {

    private static final int POST_ID = 1;
    private static final String CONTENT = "Look at this amazing view.";
    private static final String GRAPHIC_URL = "www.example/1.jpg";
    private static final LocalDateTime DATE_POSTED = LocalDateTime.now();
    PostService postService;

    @Mock
    PostRepository postRepository;
    public static final User AUTHOR = new User();

    //TODO dodać exception handling?
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        postService = new PostServiceImpl(postRepository);
    }

    @Test
    public void getAllPostsByAuthor() {
        //Given
        User author = new User();
        Post post1 = new Post();
        post1.setAuthor(author);
        Post post2 = new Post();
        post2.setAuthor(author);
        Post post3 = new Post();
        post3.setAuthor(author);
        List<Post> postsByAuthor = Arrays.asList(post1, post2, post3);
        when(postRepository.findAllByAuthor(author)).thenReturn(postsByAuthor);

        //When
        List<PostDto> postDtoListByAuthor = postService.getAllPostsByAuthor(author);

        //Then
        assertEquals(3, postDtoListByAuthor.size());
    }

    @Test
    public void getPostById() {
        //Given
        Post post = new Post();
        post.setPostId(POST_ID);
        post.setContent(CONTENT);
        post.setGraphicUrl(GRAPHIC_URL);
        post.setAuthor(AUTHOR);
        post.setDatePosted(DATE_POSTED);
        when(postRepository.findById(POST_ID)).thenReturn(Optional.ofNullable(post));

        //When
        PostDto postDto = postService.getPostById(POST_ID);

        //Then
        assertEquals(POST_ID, postDto.getPostId());
        assertEquals(CONTENT, postDto.getContent());
        assertEquals(GRAPHIC_URL, postDto.getGraphicUrl());
        assertEquals(AUTHOR, postDto.getAuthor());
        assertEquals(DATE_POSTED, postDto.getDatePosted());
    }
}
