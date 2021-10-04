package com.example.demo.projects;

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
    private String id;
    private String description;
    private Enum projectType;





}
