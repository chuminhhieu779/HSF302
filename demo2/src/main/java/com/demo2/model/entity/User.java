package com.demo2.model.entity;


import com.demo2.enums.UserGender;
import jakarta.persistence.*;
import lombok.*;

import java.lang.instrument.ClassDefinition;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userID;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "account", nullable = false, unique = true)
    private String account;

    @Column(name = "password", length = 255)
    private String password;
    // ORDINAL :0 , 1
    // STRING :  FEMALE , MALE
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "gender", length = 20)
    private UserGender gender ;

    @OneToOne(mappedBy = "user")
    private UserProfile userProfile ;

    @OneToMany(mappedBy = "user")
    private Set<Book> books;
}
