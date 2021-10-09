package src.main.java.com.example.demo.comments;

import com.example.demo.comments.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {
    @Autowired 
    private CommentRepository commentRepository;
    @Autowired
    private CommentService commentService;

    @GetMapping("/all")
    public List<Comment> findAllComment(){
        try{
            return commentService.getAll();
        } catch(Exception E){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
            "Unknown error occurs, please try again!");
        }
    }

    @GetMapping("/get/{id}")
    public Comment findCommentById(Integer id){
        try{
            return commentService.getCommentById(id);
        } catch(NullPointerException E){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Comment not found!");
        } catch(Exception E){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
            "Unknown error occurs, please try again!");
        }

    }

    @PostMapping("/add")
    public void addComment(String content){
        try{
            commentService.addComment(content);
        } catch(Exception E){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
            "Unknown error occurs, please try again!");
        }
    }
}
