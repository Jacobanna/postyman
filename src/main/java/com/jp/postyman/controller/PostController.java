package com.jp.postyman.controller;

import com.jp.postyman.domain.PostDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1")
public class PostController {
    // JUST FOR TESTING
    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    public List<PostDto> getPosts() {
        //TODO
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/posts/postId")
    public PostDto getPost() {
        //TODO
        return new PostDto();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/posts/postId")
    public void deletePost(int postId) {
        //TODO
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/posts/postId")
    public PostDto updatePost(PostDto postDto) {
        //TODO
        return new PostDto(1, "comment", "URL", 1, LocalDateTime.now());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/posts", consumes = APPLICATION_JSON_VALUE)
    public void createTask(@RequestBody PostDto postDto) {
        //TODO
    }
}
