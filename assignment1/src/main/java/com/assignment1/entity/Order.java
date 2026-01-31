package com.assignment1.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id", length = 10)
    private String Id;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 20, nullable = false)
    private String phoneNumber;

    @Column(name = "address_line1", length = 255, nullable = false)
    private String addressLine1;


    @Column(name = "address_line2", length = 255, nullable = false)
    private String addressLine2;

    @Column(name = "city", length = 100, nullable = false)
    private String city;

    @Column(name = "region", length = 100)
    private String region;

    @Column(name = "postal_code", length = 10, nullable = false)
    private String postalCode;

    @Column(name = "country", length = 50, nullable = false)
    private String country;

    // updatable = false : can not be updated after inserted data
    @Column(name = "order_date",nullable = false, updatable = false)
    private LocalDateTime orderDate;

    // allow to Hibernate ignores this field
    @Transient
    private long countID ;

    public String createID(String prefix , long countID){
        this.countID = countID ;
        return  prefix + this.countID;
    }

    /**
     * class this method before inserting data
     */
    @PrePersist
    public void prePersistTime(){
        this.orderDate = LocalDateTime.now();
    }
}
