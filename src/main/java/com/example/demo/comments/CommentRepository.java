package com.example.demo.comments;

import com.example.demo.comments.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
    
}
