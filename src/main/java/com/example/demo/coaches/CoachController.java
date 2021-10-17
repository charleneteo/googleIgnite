package com.example.demo.coaches;

import com.example.demo.coaches.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@RestController
@RequestMapping("/api/v1/coach")
public class CoachController {
    @Autowired 
    private CoachRepository coachRepository;
    @Autowired
    private CoachService coachService;

    @GetMapping("/all")
    public List<Coach> findAllCoach(){
        try{
            return coachService.getAll();
        } catch(Exception E){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
            "Unknown error occurs, please try again!");
        }
    }

    @GetMapping("/get/{email}")
    public Coach findCoachById(String email){
        try{
            return coachService.getCoachById(email);
        } catch(NullPointerException E){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Coach not found!");
        } catch(Exception E){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
            "Unknown error occurs, please try again!");
        }
    }

    @PostMapping("/add")
    public void registerCoach(Coach coach){
        try{
            coachService.addCoach(coach);
        } catch(Exception E){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
            "Unknown error occurs, please try again!");
        }
    }
}
