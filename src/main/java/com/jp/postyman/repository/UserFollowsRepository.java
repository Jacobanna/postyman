package com.jp.postyman.repository;

import com.jp.postyman.domain.User;
import com.jp.postyman.domain.UserFollows;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFollowsRepository extends JpaRepository<UserFollows, Long> {
    List<UserFollows> findAllByUser(User user);
    List<UserFollows> findAllByFollower(User user);
}
