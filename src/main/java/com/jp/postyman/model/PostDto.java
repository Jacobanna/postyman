package com.jp.postyman.model;

import com.jp.postyman.domain.Comment;
import com.jp.postyman.domain.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class PostDto {
    private Long postId;
    private String content;
    private String graphicUrl;
    private User author;
    private LocalDateTime datePosted;
//    private Set<Comment> comments;
}
