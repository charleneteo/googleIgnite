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

    public Post getPostById(Integer postId){
        Post toReturn = postRepository.findById(postId);
        if(toReturn != null){
            return toReturn;
        }
        return null;
    }

    public void addPost(String content){
        Post post = new Post();
        post.setContent(content);
    }

}
