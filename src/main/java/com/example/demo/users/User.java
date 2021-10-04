package com.example.demo.users;
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




}
