package com.example.demo.coaches;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
public class Coach {
    @Id
    @GeneratedValue(strategy=GenerationType.Identity)
    private Integer id;
    private String email;
    
    @ManyToMany
    @JoinTable(name="coach_user", 
        joinColumns
    @JoinColumn(name="user_id"),
        inverseJoinColumns
    @JoinColumn(name="coach_id"))
    private Set<User> users = new HashSet<>();

}
