package com.example.demo.comments;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JoinColumn(name="post_id")
    @JsonBackReference
    private Post post;

    
}
