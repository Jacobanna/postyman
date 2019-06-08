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
                .filter(comment -> comment.isActive())
                .map(commentMapper::commentToCommentDto)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<CommentDto> getAllCommentsByPost(Post post) {
        return commentRepository.findAllByPost(post)
                .stream()
                .filter(comment -> comment.isActive())
                .map(commentMapper::commentToCommentDto)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        Comment comment = commentMapper.commentDtoToComment(commentDto);
        comment.setActive(true);
        return saveAndReturnCommentDto(comment);
    }

    //TODO implement Exceptions for not allowed fields
    //TODO Apache Commons - zamiast ifów
    @Override
    public CommentDto patchComment(Long id, CommentDto commentDto) {
        return commentRepository.findById(id)
                .filter(comment -> comment.isActive())
                .map(comment -> {
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

    //TODO implement exception handling
    @Override
    public void deleteCommentById(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(RuntimeException::new);
        comment.setActive(false);
        commentRepository.save(comment);
    }

    private CommentDto saveAndReturnCommentDto(Comment comment) {
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.commentToCommentDto(savedComment);
    }
}
