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
    @ResponseStatus(HttpStatus.OK)
    public CommentDto getCommentById(@PathVariable int id) {
        return commentService.getCommentById(id);
    }

    @GetMapping("/posts/{post}/comments")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> getAllCommentsByPost(@PathVariable Post post) {
        return commentService.getAllCommentsByPost(post);
    }

    //TODO możesz zobaczyć w Postmanie moje @RequestBody? Tak jest w porządku?
    @PostMapping("/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto createComment(@RequestBody CommentDto commentDto) {
        return commentService.createComment(commentDto);
    }

    @PatchMapping("/comments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto patchComment(@PathVariable int id, @RequestBody CommentDto commentDto) {
        return commentService.patchComment(id, commentDto);
    }

    @DeleteMapping("/comments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCommentById(@PathVariable int id) {
        commentService.deleteCommentById(id);
    }
}
