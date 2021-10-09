package com.example.demo.posts;

import com.example.demo.users.User;
import com.example.demo.comments.Comment;
import javax.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String content;

    @OneToMany(mappedBy="post", orphanRemoval=true, cascade=CascadeType.ALL)
    private Set<Comment> comments;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
