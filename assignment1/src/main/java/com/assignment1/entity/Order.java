package com.assignment1.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")
public class Order {
    @Id
    @Column(name = "order_id", length = 10)
    private String id;

    // updatable = false : can not be updated after inserted data
    @Column(name = "order_date",nullable = false, updatable = false)
    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetailList ;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer ;

    @Transient
    private long countID ;

    public String createID(String prefix , long countID){
        this.countID = countID ;
        return  prefix + this.countID;
    }

    @PrePersist
    public void prePersistTime(){
        this.orderDate = LocalDateTime.now();
    }
}
