package com.assignment1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "customer")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Customer {
    @Id
    @Column(name = "customer_id", length = 10)
    private String id ;
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(length = 20, nullable = false, unique = true)
    private String email;

    @Column(length = 15, nullable = false)
    private String phoneNumber;

    @Column(name = "address1", length = 50, nullable = false)
    private String addressLine1;

    @Column(name = "address2", length = 50)
    private String addressLine2;
    @ManyToOne
    @JoinColumn(name = "city_id" , nullable = false)
    private City city ;

    @OneToMany(mappedBy = "customer")
    private List<Order> orderList ;

    @Transient
    private long countID ;

    public String createID(String prefix , long countID){
        this.countID = countID ;
        return  prefix + this.countID;
    }

}
