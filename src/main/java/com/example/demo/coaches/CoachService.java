package com.example.demo.coaches;

import com.example.demo.coaches.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CoachService {
    @Autowired
    private CoachRepository coachRepository;

    public List<Coach> getAll(){
        return coachRepository.findAll();
    }

    public Coach getCoachById(String email){
        Optional<Coach> coach = coachRepository.findById(email);
        if (coach.isPresent()) {
            Coach c = coach.get();
            return c;
        } else
            return null;
    }

    public void addCoach(Coach coach){
        coachRepository.save(coach);
    }
}
