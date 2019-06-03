package com.jp.postyman.controller;

import com.jp.postyman.domain.User;
import com.jp.postyman.model.PostDto;
import com.jp.postyman.model.PostDtoList;
import com.jp.postyman.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PostController.BASE_URL)
public class PostController {
    public static final String BASE_URL = "/v1";

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

//    //TODO this is not working - implement tests in repository, service and controller
    @GetMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.OK)
    public PostDtoList getAllPostsByUser(@PathVariable User id) {
        return new PostDtoList(postService.getAllPostsByAuthor(id));
    }

    @GetMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }
}
