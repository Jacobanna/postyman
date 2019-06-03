package com.jp.postyman.controller;

import com.jp.postyman.model.CommentDto;
import com.jp.postyman.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CommentController.BASE_URL)
public class CommentController {
    public static final String BASE_URL = "/v1/comments";

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto getCommentById(@PathVariable int id) {
        return commentService.getCommentById(id);
    }
}
