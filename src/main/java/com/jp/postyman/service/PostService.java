package com.jp.postyman.service;

import com.jp.postyman.domain.Post;
import com.jp.postyman.domain.User;
import com.jp.postyman.model.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> getAllPostsByAuthor(User author);
    PostDto getPostById(int id);


}
