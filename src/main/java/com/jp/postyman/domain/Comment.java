package com.jp.postyman.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity(name = "comments")
public class Comment {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private CommentId commentId;
    private String response;
    private String graphicUrl;
    private int authorId;
    private LocalDateTime dateCommented;
}
