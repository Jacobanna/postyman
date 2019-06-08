package com.jp.postyman.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @ManyToOne
    @JoinColumn(name = "post", nullable = false)
    private Post post;
    private String response;
    private String graphicUrl;
    @ManyToOne
    private User author;
    private LocalDateTime dateCommented;
}
