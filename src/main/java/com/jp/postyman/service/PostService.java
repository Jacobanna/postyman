package com.jp.postyman.service;

import com.jp.postyman.domain.Post;
import com.jp.postyman.domain.User;
import com.jp.postyman.model.PostDto;

import java.util.List;

public interface PostService {
    PostDto getPostById(Long id);
    List<PostDto> getAllPostsByAuthor(User author);
    PostDto createPost(PostDto postDto);
    PostDto patchPost(Long id, PostDto postDto);
    void deletePostById(Long id);
}
