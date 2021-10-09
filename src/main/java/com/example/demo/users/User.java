package com.example.demo.users;
import com.example.demo.projects.Project;
import com.example.demo.coaches.Coach;
import com.example.demo.posts.Post;
import lombok.*;

import javax.persistence.*;
import java.util.*;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Data
public class User {
    @Id
    @Column(name = "email", nullable = false)
    private String email;
    private String fname;
    private String lname;
    private String password;

    @ManyToMany
    @JoinTable(name="projectAndUsers",
    joinColumns=@JoinColumn(name="email"),
    inverseJoinColumns=@JoinColumn(name="projectId"))
    List<Project> userProjects;

    public User(String email, String fname, String lname, String password) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
    }
}
