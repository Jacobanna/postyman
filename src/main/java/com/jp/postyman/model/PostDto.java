package com.jp.postyman.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class PostDto {
    private int postId;
    private String content;
    private String graphicUrl;
    private int authorId;
    private LocalDateTime datePosted;
}
