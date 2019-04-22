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
public class User {
    private int userId;
    private String name;
    private String password;
    private String graphicUrl;
    private LocalDateTime dateJoined;
    private String email;
}
