package com.jp.postyman.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private int postId;
    private int commentId;
    private String response;
    private String graphicUrl;
    private int authorId;
    private LocalDateTime dateCommented;
}
