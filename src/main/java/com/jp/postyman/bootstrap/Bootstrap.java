package com.jp.postyman.bootstrap;

import com.jp.postyman.domain.Comment;
import com.jp.postyman.domain.CommentId;
import com.jp.postyman.domain.Post;
import com.jp.postyman.domain.User;
import com.jp.postyman.repository.CommentRepository;
import com.jp.postyman.repository.PostRepository;
import com.jp.postyman.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class Bootstrap implements CommandLineRunner {
    private UserRepository userRepository;
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public Bootstrap(UserRepository userRepository, PostRepository postRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void run(String... args) {
        User user1 = new User();
        user1.setUserId(1);
        user1.setName("Anna");
        user1.setPassword("pooswa1");
        user1.setProfilePhotoUrl("www.example1.jpg");
        user1.setDateJoined(LocalDate.now());
        user1.setEmail("anna@email.com");
        userRepository.save(user1);

        User user2 = new User();
        user2.setUserId(2);
        user2.setName("Mark");
        user2.setPassword("sdkowao");
        user2.setProfilePhotoUrl("www.example2.jpg");
        user2.setDateJoined(LocalDate.now());
        user2.setEmail("mark@email.com");
        userRepository.save(user2);

        User user3 = new User();
        user3.setUserId(3);
        user3.setName("Bethany");
        user3.setPassword("djwkirwkqq1");
        user3.setProfilePhotoUrl("www.example3.jpg");
        user3.setDateJoined(LocalDate.now());
        user3.setEmail("bethany@email.com");
        userRepository.save(user3);

        System.out.println("Data loaded - " + userRepository.count() + " elements added to Users table.");

        Post user1Post1 = new Post();
        user1Post1.setPostId(1);
        user1Post1.setAuthor(user1);
        user1Post1.setContent("Such beautiful weather!!");
        user1Post1.setDatePosted(LocalDateTime.now());
        user1Post1.setGraphicUrl("www.graphic1.jpg");
        postRepository.save(user1Post1);

        Post user1Post2 = new Post();
        user1Post2.setPostId(2);
        user1Post2.setAuthor(user1);
        user1Post2.setContent("Hello guys in the world.");
        user1Post2.setDatePosted(LocalDateTime.now());
        user1Post2.setGraphicUrl("www.graphic2.jpg");
        postRepository.save(user1Post2);

        Post user2Post1 = new Post();
        user2Post1.setPostId(3);
        user2Post1.setAuthor(user2);
        user2Post1.setContent("Checkout my new walls.");
        user2Post1.setDatePosted(LocalDateTime.now());
        user2Post1.setGraphicUrl("www.graphic3.jpg");
        postRepository.save(user2Post1);

        Post user2Post2 = new Post();
        user2Post2.setPostId(4);
        user2Post2.setAuthor(user2);
        user2Post2.setContent("Feeling good.");
        user2Post2.setDatePosted(LocalDateTime.now());
        postRepository.save(user2Post2);

        Post user3Post1 = new Post();
        user3Post1.setPostId(5);
        user3Post1.setAuthor(user3);
        user3Post1.setContent("Amazing art.");
        user3Post1.setGraphicUrl("www.graphic4.jpg");
        user3Post1.setDatePosted(LocalDateTime.now());
        postRepository.save(user3Post1);

        System.out.println("Data loaded - " + postRepository.count() + " elements added to Posts table.");

        //todo For testing compound id
        CommentId commentId = new CommentId();
        commentId.setPrimaryCommentId(1);
        commentId.setPost(1);
        Comment comment = new Comment();
        comment.setAuthorId(1);
        comment.setCommentId(commentId);
        comment.setDateCommented(LocalDateTime.now());
        comment.setResponse("I don't think so.");
        commentRepository.save(comment);
    }
}