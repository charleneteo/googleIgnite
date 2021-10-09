package com.example.demo.comments;

import com.example.demo.posts.Post;
import com.example.demo.users.User;
import javax.persistence.*;
import lombok.*;
import java.util.*;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String content;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;
}
