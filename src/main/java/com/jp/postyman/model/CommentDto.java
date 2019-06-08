package com.jp.postyman.model;

import com.jp.postyman.domain.Post;
import com.jp.postyman.domain.User;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class CommentDto {
    private Long commentId;
    private Post post;
    private String response;
    private String graphicUrl;
    private User author;
    private LocalDateTime dateCommented;
}
