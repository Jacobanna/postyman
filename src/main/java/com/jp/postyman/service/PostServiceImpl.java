package com.jp.postyman.service;

import com.jp.postyman.domain.User;
import com.jp.postyman.mapper.PostMapper;
import com.jp.postyman.model.PostDto;
import com.jp.postyman.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

//    @Override
//    public List<PostDto> getAllPostsByUser(User author) {
//        return postRepository.findByAuthor(author)
//                .stream()
//                .map(PostMapper.INSTANCE::postToPostDto)
//                .collect(Collectors.toList());
//    }

    @Override
    public PostDto getPostById(int id) {
        return postRepository.findById(id)
                .map(PostMapper.INSTANCE::postToPostDto)
                .orElseThrow(RuntimeException::new);
    }
}
