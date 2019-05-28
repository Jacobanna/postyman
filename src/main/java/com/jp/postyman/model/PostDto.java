package com.jp.postyman.model;

import com.jp.postyman.domain.User;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class PostDto {
    private int postId;
    private String content;
    private String graphicUrl;
    private User author;
    private LocalDateTime datePosted;
    //todo tutaj nie powinno być
    //todo private Set<Comment> comments;
    //todo prawda? tego Setu używam tylko żeby połączyć tablice w bazie danych.
}
