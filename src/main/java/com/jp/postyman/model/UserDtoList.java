package com.jp.postyman.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDtoList {
    List<UserDto> userDtoList;
}
