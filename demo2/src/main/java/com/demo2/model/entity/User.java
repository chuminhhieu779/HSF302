package com.demo2.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user", schema = "suzune")
public class User {
    @Id()
    private int userID;
    private String fullname;
    private String account;
    private String password;

}
