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
    public CommentDto getCommentById(Long id) {
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

    //TODO implement Exceptions for not allowed fields
    //TODO Apache Commons - zamiast ifów
    @Override
    public CommentDto patchComment(Long id, CommentDto commentDto) {
        return commentRepository.findById(id).map(comment -> {
            //TODO any way I can do this clean? Seems pretty bad
            if(commentDto.getCommentId() != null) {
                System.out.println("Cannot change comment ID.");
                return null;
            }
            if(commentDto.getPost() != null) {
                System.out.println("Cannot change in which post comment was created.");
                return null;
            }
            if(commentDto.getResponse() != null) {
                comment.setResponse(commentDto.getResponse());
            }
            if(commentDto.getGraphicUrl() != null) {
                comment.setGraphicUrl(commentDto.getGraphicUrl());
            }
            if(commentDto.getAuthor() != null) {
                System.out.println("Cannot change author of comment.");
                return null;
            }
            if(commentDto.getDateCommented() != null) {
                comment.setDateCommented(commentDto.getDateCommented());
            }

            return commentMapper.commentToCommentDto(commentRepository.save(comment));
        }).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }

    private CommentDto saveAndReturnCommentDto(Comment comment) {
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.commentToCommentDto(savedComment);
    }
}
