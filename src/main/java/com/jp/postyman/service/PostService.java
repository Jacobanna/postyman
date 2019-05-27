package com.jp.postyman.service;

import com.jp.postyman.domain.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPostsByUser(int userId);
    Post getPostById(int id);


}
