package com.example.demo.posts;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String content;

    @OneToMany(mappedBy="post", orphanRemoval=true, cascade=CascadeType.ALL)
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
