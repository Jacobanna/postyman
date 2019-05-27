package com.jp.postyman.repository;

import com.jp.postyman.domain.Comment;
import com.jp.postyman.domain.CommentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, CommentId> {
}
