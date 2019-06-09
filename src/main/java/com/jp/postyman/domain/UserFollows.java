package com.jp.postyman.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_follows")
public class UserFollows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "follower")
    private User follower;
    private boolean isActive;
}
