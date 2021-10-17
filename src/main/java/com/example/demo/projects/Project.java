package com.example.demo.projects;

import com.example.demo.users.User;
import com.example.demo.projects.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer projectId;
    private String description;
    private String projectType;
    @ManyToMany(mappedBy="userProjects")
    List<User> users;
}
