package com.assignment1.entity;


import jakarta.persistence.*;

@Table(
        name = "order_detail" ,
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"order_id", "product_id"}
                )
        }
)
@Entity
public class OrderDetail {

    @Id
    @Column(name = "order_detail_id") // -- surrogate key
    private String id ;

    @Column(name = "quantity" , nullable = false)
    private int quantity ;

    @ManyToOne
    @JoinColumn(name = "order_id" , nullable = false) // natural key
    Order order ;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false) // natural key
    Product product ;
}
