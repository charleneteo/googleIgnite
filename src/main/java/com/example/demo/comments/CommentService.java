package com.example.demo.comments;

import com.example.demo.comments.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAll(){
        return commentRepository.findAll();
    }

    public Comment getCommentById(Integer commentId){
        Optional<Comment> c = commentRepository.findById(commentId);
        if (c.isPresent()) {
            Comment comment = c.get();
            return comment;
        } else
            return null;
    }

    public void addComment(String content){
        Comment comment = new Comment();
        comment.setContent(content);
        commentRepository.save(comment);
    }
}
