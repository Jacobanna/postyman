package com.jp.postyman.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String password;
    private String profilePhotoUrl;
    private LocalDate dateJoined;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private Set<Post> posts;
    @ManyToMany
    @JoinTable(name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private Set<User> userFriends;
    @ManyToMany
    @JoinTable(name = "users_friends",
            joinColumns = @JoinColumn(name = "friend_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> friendsOfUser;
}
