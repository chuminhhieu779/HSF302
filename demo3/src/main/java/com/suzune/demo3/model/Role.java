package com.suzune.demo3.model;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "Roles")
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id ;
    @Column(name = "role_name", length = 100, nullable = false)
    private String roleName ;
    @ManyToMany
    @JoinTable(
            name = "User_Roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> user ;
}
