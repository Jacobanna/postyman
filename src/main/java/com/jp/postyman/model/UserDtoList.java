package com.jp.postyman.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDtoList {
    //TODO to jest nazwa jaka pola w JSONie która zostanie zwrócona. Czy jest taka konwencja że skoro mój endpoint to
    // /v1/users to tutaj też powinienem mieć users? Czy np userDtoList jest spoko?
    List<UserDto> users;
}
