package com.example.demo.posts;

import com.example.demo.posts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    @Autowired 
    private PostRepository postRepository;
    @Autowired
    private PostService postService;

    @GetMapping("/all")
    public List<Post> findAllComment(){
        try{
            return postService.getAll();
        } catch(Exception E){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
            "Unknown error occurs, please try again!");
        }
    }

    @GetMapping("/get/{id}")
    public Coach findPostById(Integer id){
        try{
            return postService.getPostById(id);
        } catch(NullPointerException E){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Comment not found!");
        } catch(Exception E){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
            "Unknown error occurs, please try again!");
        }

    }

    @PostMapping("/add")
    public void addPost(String content){
        try{
            postService.addPost(content);
        } catch(Exception E){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
            "Unknown error occurs, please try again!");
        }
    }
}
