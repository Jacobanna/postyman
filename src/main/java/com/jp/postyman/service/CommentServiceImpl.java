package com.jp.postyman.service;

import com.jp.postyman.domain.Post;
import com.jp.postyman.mapper.CommentMapper;
import com.jp.postyman.model.CommentDto;
import com.jp.postyman.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<CommentDto> getAllCommentsByPost(Post post) {
        return commentRepository.findAllByPost(post)
                .stream()
                .map(CommentMapper.INSTANCE::commentToCommentDto)
                .collect(Collectors.toList());
    }
}
