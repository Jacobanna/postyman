package com.jp.postyman.service;

import com.jp.postyman.domain.Comment;
import com.jp.postyman.domain.Post;
import com.jp.postyman.domain.User;
import com.jp.postyman.mapper.UserMapper;
import com.jp.postyman.model.UserDto;
import com.jp.postyman.repository.CommentRepository;
import com.jp.postyman.repository.PostRepository;
import com.jp.postyman.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PostRepository postRepository,
                           CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public UserDto getUserById(Long id) {
        return userRepository.findById(id)
                .filter(user -> user.isActive())
                .map(userMapper::userToUserDto)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .filter(user -> user.isActive())
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
    }

    //TODO zmien na findByNameAndEmail
    //TODO implement exceptions for name/email already used
    @Override
    public UserDto createUser(UserDto userDto) {
        List<UserDto> allUsers = getAllUsers();
        for (UserDto existingUser: allUsers) {
            if(userDto.getName().equals(existingUser.getName())) {
                System.out.println("Name already used.");
                return null;
            } else if (userDto.getEmail().equals(existingUser.getEmail())) {
                System.out.println("Email already used.");
                return null;
            }
        }
        return saveAndReturnUserDto(userMapper.userDtoToUser(userDto));
    }


    //TODO refactor this? too long method
    @Override
    public void deleteUserById(Long id) {
        User user = userRepository.findUserByUserId(id);
        if(user.isActive()) {
            //1. Delete comments under user posts and posts
            List<Post> userPosts = postRepository.findAllByAuthor(user);
            userPosts.forEach(post -> {
                List<Comment> comments = commentRepository.findAllByPost(post);
                comments.forEach(comment -> {
                    if(comment.isActive()) {
                        comment.setActive(false);
                        commentRepository.save(comment);
                    }
                });
                post.setActive(false);
                postRepository.save(post);
            });
            //2. Delete comments that user posted on different posts
            List<Comment> userComments = commentRepository.findAllByAuthor(user);
            userComments.forEach(comment -> {
                if(comment.isActive()) {
                    comment.setActive(false);
                    commentRepository.save(comment);
                }
            });
            //3. Delete user following

            //4. Delete following user

            //5. Delete user itself
            user.setActive(false);
            userRepository.save(user);
        }
    }

    private UserDto saveAndReturnUserDto(User user) {
        User savedUser = userRepository.save(user);
        return userMapper.userToUserDto(savedUser);
    }
}
