package com.example.demo.users;
import com.example.demo.projects.Project;
import lombok.*;

import javax.persistence.*;
import java.util.*;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@AllArgsConstructor

public class User {
    @Id
    @Column(name = "email", nullable = false)
    private String email;
    private String fname;
    private String lname;
    private String password;

    @ManyToMany
    @JoinTable(name="",
    joinColumns=@JoinColumn(name="email"),
    inverseJoinColumns=@JoinColumn(name="projectId"))
    ArrayList<Project> userProjects;

    public User(String email, String fname, String lname, String password) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
    }
}
