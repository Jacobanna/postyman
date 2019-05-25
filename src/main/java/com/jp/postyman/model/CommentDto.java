package com.jp.postyman.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class CommentDto {
    private int postId;
    private int commentId;
    private String response;
    private String graphicUrl;
    private int authorId;
    private LocalDateTime dateCommented;
}
