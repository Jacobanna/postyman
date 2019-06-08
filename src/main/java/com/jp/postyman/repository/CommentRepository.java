package com.jp.postyman.repository;

import com.jp.postyman.domain.Comment;
import com.jp.postyman.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost(Post post);
}
