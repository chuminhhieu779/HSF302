package com.assignment1.entity;


import jakarta.persistence.*;

import java.util.List;

@Table(name = "product")
@Entity
public class Product {
    @Id
    @Column(name = "product_id", length = 10)
    private String id ;
    @Column(name = "name" , length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetailList;
}
