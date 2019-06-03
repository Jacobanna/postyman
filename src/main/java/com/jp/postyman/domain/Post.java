package com.jp.postyman.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    private String content;
    private String graphicUrl;
    //TODO Po usunięciu z Usera List<Post> posts nie potrafię zrobić DELETE CASCADE (jak usunę Usera chcę usunąć
    // wszystkie jego posty. Da się to jakoś zrobić bez tej drugiej strony połączenia? Albo po prostu ręcznie to
    // robić? W sensie jak będę miał DELETE na Userze to muszę zadbać o to żeby usunąć wszystkie jego posty?
    @ManyToOne
    @JoinColumn(name = "author")
    private User author;
    private LocalDateTime datePosted;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
//    private Set<Comment> comments;
}
