package com.jp.postyman.repository;

import com.jp.postyman.domain.User;
import com.jp.postyman.model.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserId(Long id);
}
