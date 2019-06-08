package com.jp.postyman.model;

import lombok.*;

import java.time.LocalDate;

@Data
public class UserDto {
    private Long userId;
    private String name;
    private String password;
    private String profilePhotoUrl;
    private LocalDate dateJoined;
    private String email;
    //TODO czy chcę tu mieć Set<User> userFollows?
}
