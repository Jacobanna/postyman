package com.jp.postyman.service;

import com.jp.postyman.domain.Post;
import com.jp.postyman.model.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto getCommentById(Long id);
    List<CommentDto> getAllCommentsByPost(Post post);
    CommentDto createComment(CommentDto commentDto);
    CommentDto patchComment(Long id, CommentDto commentDto);
    void deleteCommentById(Long id);
}
