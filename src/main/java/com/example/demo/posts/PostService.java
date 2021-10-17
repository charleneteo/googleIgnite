package com.example.demo.posts;

import com.example.demo.posts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAll(){
        return postRepository.findAll();
    }

    public Post getPostById(int postId){
        Optional<Post> p = postRepository.findById(postId);
        if (p.isPresent()) {
            Post post = p.get();
            return post;
        } else
            return null;
    }

    public void addPost(Post post){
        postRepository.save(post);
    }
}
