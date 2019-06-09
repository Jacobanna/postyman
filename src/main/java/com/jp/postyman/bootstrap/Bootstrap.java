package com.jp.postyman.bootstrap;

import com.jp.postyman.domain.Comment;
import com.jp.postyman.domain.Post;
import com.jp.postyman.domain.User;
import com.jp.postyman.repository.CommentRepository;
import com.jp.postyman.repository.PostRepository;
import com.jp.postyman.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
        user1.setUserId(1L);
        user1.setName("Anna");
        user1.setPassword("pooswa1");
        user1.setProfilePhotoUrl("www.example1.jpg");
        user1.setDateJoined(LocalDate.now());
        user1.setEmail("anna@email.com");
        user1.setActive(true);
        userRepository.save(user1);

        User user2 = new User();
        user2.setUserId(2L);
        user2.setName("Mark");
        user2.setPassword("sdkowao");
        user2.setProfilePhotoUrl("www.example2.jpg");
        user2.setDateJoined(LocalDate.now());
        user2.setEmail("mark@email.com");
        user2.setActive(true);
        userRepository.save(user2);

        User user3 = new User();
        user3.setUserId(3L);
        user3.setName("Bethany");
        user3.setPassword("djwkirwkqq1");
        user3.setProfilePhotoUrl("www.example3.jpg");
        user3.setDateJoined(LocalDate.now());
        user3.setEmail("bethany@email.com");
        user3.setActive(true);
        userRepository.save(user3);

        System.out.println(userRepository.count() + " elements added to Users table.");

        Set<User> user1Friends = new HashSet<>();
        user1Friends.add(user2);
        user1Friends.add(user3);
        user1.setUserFollows(user1Friends);
        userRepository.save(user1);

        Set<User> user2Friends = new HashSet<>();
        user2Friends.add(user3);
        user2.setUserFollows(user2Friends);
        userRepository.save(user2);

        Set<User> user3Friends = new HashSet<>();
        user3Friends.add(user1);
        user3.setUserFollows(user3Friends);
        userRepository.save(user3);

        Set<User> user3FriendsAgain = new HashSet<>();
        user3FriendsAgain.add(user1);
        user3.setUserFollows(user3FriendsAgain);
        userRepository.save(user3);

        System.out.println("Connections between Users added.");


        Post user1Post1 = new Post();
        user1Post1.setPostId(1L);
        user1Post1.setAuthor(user1);
        user1Post1.setContent("Such beautiful weather!!");
        user1Post1.setDatePosted(LocalDateTime.now());
        user1Post1.setGraphicUrl("www.graphic1.jpg");
        user1Post1.setActive(true);
        postRepository.save(user1Post1);

        Post user1Post2 = new Post();
        user1Post2.setPostId(2L);
        user1Post2.setAuthor(user1);
        user1Post2.setContent("Hello guys in the world.");
        user1Post2.setDatePosted(LocalDateTime.now());
        user1Post2.setGraphicUrl("www.graphic2.jpg");
        user1Post2.setActive(true);
        postRepository.save(user1Post2);

        Post user2Post1 = new Post();
        user2Post1.setPostId(3L);
        user2Post1.setAuthor(user2);
        user2Post1.setContent("Checkout my new walls.");
        user2Post1.setDatePosted(LocalDateTime.now());
        user2Post1.setGraphicUrl("www.graphic3.jpg");
        user2Post1.setActive(true);
        postRepository.save(user2Post1);

        Post user2Post2 = new Post();
        user2Post2.setPostId(4L);
        user2Post2.setAuthor(user2);
        user2Post2.setContent("Feeling good.");
        user2Post2.setDatePosted(LocalDateTime.now());
        user2Post2.setActive(true);
        postRepository.save(user2Post2);

        Post user3Post1 = new Post();
        user3Post1.setPostId(5L);
        user3Post1.setAuthor(user3);
        user3Post1.setContent("Amazing art.");
        user3Post1.setGraphicUrl("www.graphic4.jpg");
        user3Post1.setDatePosted(LocalDateTime.now());
        user3Post1.setActive(true);
        postRepository.save(user3Post1);

        System.out.println(postRepository.count() + " elements added to Posts table.");

        Comment user1post1Comment1 = new Comment();
        user1post1Comment1.setCommentId(1L);
        user1post1Comment1.setPost(user1Post1);
        user1post1Comment1.setResponse("Ahahahha");
        user1post1Comment1.setGraphicUrl("www.graphic1.jpg");
        user1post1Comment1.setAuthor(user2);
        user1post1Comment1.setDateCommented(LocalDateTime.now());
        user1post1Comment1.setActive(true);
        commentRepository.save(user1post1Comment1);

        Comment user1post1Comment2 = new Comment();
        user1post1Comment2.setCommentId(2L);
        user1post1Comment2.setPost(user1Post1);
        user1post1Comment2.setResponse("Nice");
        user1post1Comment2.setGraphicUrl("www.graphic2.jpg");
        user1post1Comment2.setAuthor(user3);
        user1post1Comment2.setDateCommented(LocalDateTime.now());
        user1post1Comment2.setActive(true);
        commentRepository.save(user1post1Comment2);

        Comment user2post1Comment1 = new Comment();
        user2post1Comment1.setCommentId(3L);
        user2post1Comment1.setPost(user2Post1);
        user2post1Comment1.setResponse("WOW");
        user2post1Comment1.setGraphicUrl("www.graphic3.jpg");
        user2post1Comment1.setAuthor(user3);
        user2post1Comment1.setDateCommented(LocalDateTime.now());
        user2post1Comment1.setActive(true);
        commentRepository.save(user2post1Comment1);

        Comment user3post1Comment1 = new Comment();
        user3post1Comment1.setCommentId(4L);
        user3post1Comment1.setPost(user3Post1);
        user3post1Comment1.setResponse("Incredible!");
        user3post1Comment1.setAuthor(user1);
        user3post1Comment1.setDateCommented(LocalDateTime.now());
        user3post1Comment1.setActive(true);
        commentRepository.save(user3post1Comment1);

        System.out.println(commentRepository.count() + " elements added to Comments table.");
    }
}
