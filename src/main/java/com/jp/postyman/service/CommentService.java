package com.jp.postyman.service;

import com.jp.postyman.domain.Post;
import com.jp.postyman.model.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto);
    CommentDto getCommentById(Long id);
    List<CommentDto> getAllCommentsByPost(Post post);
    CommentDto patchComment(Long id, CommentDto commentDto);
    void deleteCommentById(Long id);
}
