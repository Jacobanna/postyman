package com.jp.postyman.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int postId;
    private String content;
    private String graphicUrl;
    private int authorId;
    private LocalDateTime datePosted;
}
