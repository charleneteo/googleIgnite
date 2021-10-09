package com.example.demo.projects;

import com.example.demo.users.User;
import lombok.*;

import javax.persistence.*;
import java.util.*;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@AllArgsConstructor

public class Project {
    @Id
    @Column(name = "email", nullable = false)
    private String projectId;
    private String description;
    private Enum projectType;

    @ManyToMany(mappedBy="userProjects")
    List<User> users;

    public Project(String projectId, String description, Enum projectType) {
        this.projectId = projectId;
        this.description = description;
        this.projectType = projectType;
    }


}
