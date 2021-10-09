package com.example.demo.coaches;

import com.example.demo.users.User;
import javax.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Data
public class Coach {
    @Id
    private String email;
    
    @ManyToMany
    @JoinTable(name="coach_user", 
        joinColumns=
    @JoinColumn(name="user_id"),
        inverseJoinColumns=
    @JoinColumn(name="coach_id"))
    private Set<User> users = new HashSet<>();

}
