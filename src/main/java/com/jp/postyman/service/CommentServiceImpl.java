package com.jp.postyman.service;

import com.jp.postyman.mapper.CommentMapper;
import com.jp.postyman.model.CommentDto;
import com.jp.postyman.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDto getCommentById(int id) {
        return commentRepository.findById(id)
                .map(CommentMapper.INSTANCE::commentToCommentDto)
                .orElseThrow(RuntimeException::new);
    }
}
