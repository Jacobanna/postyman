package com.jp.postyman.service;

import com.jp.postyman.domain.Comment;
import com.jp.postyman.domain.Post;
import com.jp.postyman.domain.User;
import com.jp.postyman.mapper.CommentMapper;
import com.jp.postyman.mapper.PostMapper;
import com.jp.postyman.model.PostDto;
import com.jp.postyman.repository.CommentRepository;
import com.jp.postyman.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    PostRepository postRepository;
    PostMapper postMapper;
    CommentRepository commentRepository;

    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
        this.commentRepository = commentRepository;
    }

    @Override
    public PostDto getPostById(Long id) {
        return postRepository.findById(id)
                .filter(post -> post.isActive())
                .map(PostMapper.INSTANCE::postToPostDto)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<PostDto> getAllPostsByAuthor(User author) {
        return postRepository.findAllByAuthor(author).stream()
                .filter(post -> post.isActive())
                .map(PostMapper.INSTANCE::postToPostDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = postMapper.postDtoToPost(postDto);
        post.setActive(true);
        return saveAndReturnPostDto(post);
    }

    //TODO implement Exceptions for not allowed fields
    //TODO Apache Commons - zamiast ifów
    @Override
    public PostDto patchPost(Long id, PostDto postDto) {
        return postRepository.findById(id)
                .filter(post -> post.isActive())
                .map(post -> {
            if(postDto.getPostId() != null) {
                System.out.println("Cannot change post ID.");
                return null;
            }
            if(postDto.getContent() != null) {
                post.setContent(postDto.getContent());
            }
            if(postDto.getGraphicUrl() != null) {
                post.setGraphicUrl(postDto.getGraphicUrl());
            }
            if(postDto.getAuthor() != null) {
                System.out.println("Cannot change author of post.");
                return null;
            }
            if(postDto.getDatePosted() != null) {
                post.setDatePosted(postDto.getDatePosted());
            }

            return postMapper.postToPostDto(postRepository.save(post));
        }).orElseThrow(RuntimeException::new);
    }

    //TODO implement exception handling
    @Override
    public void deletePostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(RuntimeException::new);
        List<Comment> comments = commentRepository.findAllByPost(post);
        comments.forEach(comment -> {
            comment.setActive(false);
            commentRepository.save(comment);
        });
        post.setActive(false);
        postRepository.save(post);
    }

    private PostDto saveAndReturnPostDto(Post post) {
        Post savedPost = postRepository.save(post);
        return postMapper.postToPostDto(savedPost);
    }
}
