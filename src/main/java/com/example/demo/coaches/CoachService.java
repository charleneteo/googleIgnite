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

    public Coach getCoachById(Integer coachId){
        Coach toReturn = coachRepository.findById(coachId);
        if(toReturn != null){
            return toReturn;
        }
        return null;
    }
}
