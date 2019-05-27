package com.jp.postyman.model;

import lombok.*;

import java.time.LocalDate;

@Data
public class UserDto {
    private int userId;
    private String name;
    private String password;
    private String profilePhotoUrl;
    private LocalDate dateJoined;
    private String email;
    //todo tutaj nie powinno być
    //private Set<Post> posts;
    //prawda? tego Setu używam tylko żeby połączyć tablice w bazie dancych.

}
