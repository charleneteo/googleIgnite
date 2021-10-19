package com.example.demo.users;

import com.example.demo.projects.Project;
import com.example.demo.coaches.Coach;
import com.example.demo.posts.Post;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.io.*;
import java.util.*;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Data
public class User implements Serializable{
    @Id
    private String email;
    private String fname;
    private String lname;
    private String password;

    @ManyToMany
    @JoinTable(name="projectAndUsers",
    joinColumns=@JoinColumn(name="email"),
    inverseJoinColumns=@JoinColumn(name="projectId"))
    private Set<Project> userProjects;

    @OneToMany(mappedBy="user")
    @JsonManagedReference
    private List<Post> posts;

    @ManyToMany(mappedBy="users")
    private Set<Coach> coaches;
    
    public User(String email, String fname, String lname, String password) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
    }
}
