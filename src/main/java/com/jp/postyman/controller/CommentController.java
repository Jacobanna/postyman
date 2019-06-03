package com.jp.postyman.controller;

import com.jp.postyman.domain.Post;
import com.jp.postyman.model.CommentDto;
import com.jp.postyman.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CommentController.BASE_URL)
public class CommentController {
    public static final String BASE_URL = "/v1";

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments/{id}")
    public CommentDto getCommentById(@PathVariable int id) {
        return commentService.getCommentById(id);
    }

    @GetMapping("/posts/{post}/comments")
    public List<CommentDto> getAllCommentsByPost(@PathVariable Post post) {
        return commentService.getAllCommentsByPost(post);
    }
}
