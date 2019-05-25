package com.jp.postyman.bootstrap;

import com.jp.postyman.domain.User;
import com.jp.postyman.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Bootstrap implements CommandLineRunner {
    private UserRepository userRepository;

    public Bootstrap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        populateUsers();
    }

    private void populateUsers() {
        User user1 = new User();
        user1.setUserId(1);
        user1.setName("Anna");
        user1.setPassword("pooswa1");
        user1.setGraphicUrl("www.example1.jpg");
        user1.setDateJoined(LocalDate.now());
        user1.setEmail("anna@email.com");
        userRepository.save(user1);

        User user2 = new User();
        user2.setUserId(2);
        user2.setName("Mark");
        user2.setPassword("sdkowao");
        user2.setGraphicUrl("www.example2.jpg");
        user2.setDateJoined(LocalDate.now());
        user2.setEmail("mark@email.com");
        userRepository.save(user2);

        User user3 = new User();
        user3.setUserId(3);
        user3.setName("Bethany");
        user3.setPassword("djwkirwkqq1");
        user3.setGraphicUrl("www.example3.jpg");
        user3.setDateJoined(LocalDate.now());
        user3.setEmail("bethany@email.com");
        userRepository.save(user3);

        System.out.println("Data loaded - " + userRepository.count() + " elements added to Users table.");
    }
}
