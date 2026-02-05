package com.assignment1.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "product")
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "product_id", length = 10)
    private String id ;
    @Column(name = "name" , length = 50, nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private int quantity ;

    @Transient
    private long countID ;

    public String createID(String prefix , long countID){
        this.countID = countID ;
        return  prefix + this.countID;
    }
    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetailList;
}
