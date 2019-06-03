package com.jp.postyman.service;

import com.jp.postyman.domain.Comment;
import com.jp.postyman.domain.Post;
import com.jp.postyman.mapper.CommentMapper;
import com.jp.postyman.model.CommentDto;
import com.jp.postyman.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
        this.commentMapper = CommentMapper.INSTANCE;
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

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        return saveAndReturnCommentDto(commentMapper.commentDtoToComment(commentDto));
    }

    private CommentDto saveAndReturnCommentDto(Comment comment) {
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.commentToCommentDto(savedComment);
    }
}
