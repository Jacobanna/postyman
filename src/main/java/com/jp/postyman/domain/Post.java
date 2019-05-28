package com.jp.postyman.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    private String content;
    private String graphicUrl;
    @ManyToOne
    @JoinColumn(name = "author", nullable = false)
    private User author;
    private LocalDateTime datePosted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private Set<Comment> comments;
}
