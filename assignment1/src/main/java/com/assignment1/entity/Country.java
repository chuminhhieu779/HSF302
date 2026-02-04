package com.assignment1.entity;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "country")
@Entity
public class Country {
    @Id
    @Column(name = "country_id" , length = 10 , nullable = false)
    private String id ;
    @Column(name = "name", length = 20 , nullable = false)
    private String name ;
    @OneToMany(mappedBy = "country")
    private List<City> cityList ;


}
