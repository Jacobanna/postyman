package com.jp.postyman.service;

import com.jp.postyman.domain.Post;
import com.jp.postyman.domain.User;
import com.jp.postyman.mapper.PostMapper;
import com.jp.postyman.model.PostDto;
import com.jp.postyman.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    PostRepository postRepository;
    PostMapper postMapper;

    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override
    public List<PostDto> getAllPostsByUser(User author) {
        return postRepository.findByAuthor(author)
                .stream()
                .map(postMapper::postToPostDto)
                .collect(Collectors.toList());
    }


    //TODO czy ta metoda jest ok?
    @Override
    public PostDto getPostById(int id) {
        Optional<Post> postOptional = postRepository.findById(id);
        if(postOptional.isPresent()) {
            return postMapper.postToPostDto(postOptional.get());
        } else {
            return null;
        }
    }
}
