package com.assignment1.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "city")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class City {
    @Id
    @Column(name = "city_id", length = 10)
    private String id ;
    @Column(name = "name", length = 50, nullable = false)
    private String name ;
    @Column(name = "region", length = 20 , nullable = false)
    private String region ;
    @Column(name = "postal_code", length = 10, nullable = false)
    private String postalCode ;
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country ;
    @OneToMany(mappedBy = "city")
    private List<Customer> customerList ;

    @Transient
    private long countID ;

    public String createID(String prefix , long countID){
        this.countID = countID ;
        return  prefix + this.countID;
    }

}
