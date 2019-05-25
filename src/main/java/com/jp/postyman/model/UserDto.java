package com.jp.postyman.model;

import lombok.*;

import java.time.LocalDate;

@Data
public class UserDto {
    private int userId;
    private String name;
    private String password;
    private String graphicUrl;
    private LocalDate dateJoined;
    private String email;
}
