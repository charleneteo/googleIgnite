package src.main.java.com.example.demo.comments;

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
        Comment toReturn = commentRepository.findById(commentId);
        if(toReturn != null){
            return toReturn;
        }
        return null;
    }

    public void addComment(String content){
        Comment comment = new Comment();
        comment.setComment(content);
    }
}
