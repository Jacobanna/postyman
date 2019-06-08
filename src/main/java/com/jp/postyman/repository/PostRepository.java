package com.jp.postyman.repository;

import com.jp.postyman.domain.Post;
import com.jp.postyman.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByAuthor(User author);
}
