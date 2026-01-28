package com.ordermanagement.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id", length = 10)
    private String Id;

    @NotBlank
    @Size(min = 2, max = 50)
    @Pattern(regexp = "^[A-Za-z ]+$")
    @Column(length = 50, nullable = false)
    private String firstName;


    @NotBlank
    @Size(min = 2, max = 50)
    @Pattern(regexp = "^[A-Za-z ]+$")
    @Column(length = 50, nullable = false)
    private String lastName;

    @NotBlank
    @Email
    @Column(length = 100, nullable = false, unique = true)
    private String email;


    @NotBlank
    @Pattern(regexp = "^\\+[0-9 ]{7,20}$")
    @Column(length = 20, nullable = false)
    private String phoneNumber;


    @NotBlank
    @Column(name = "address_line1", length = 255, nullable = false)
    private String addressLine1;

    @NotBlank
    @Column(name = "address_line2", length = 255, nullable = false)
    private String addressLine2;

    @NotBlank
    @Column(name = "city", length = 100, nullable = false)
    private String city;


    @Column(name = "region", length = 100)
    private String region;

    @NotBlank
    @Size(min = 3, max = 10)
    @Pattern(regexp = "^[A-Za-z0-9]+$")
    @Column(name = "postal_code", length = 10, nullable = false)
    private String postalCode;

    @NotBlank
    @Column(name = "country", length = 50, nullable = false)
    private String country;

    // updatable = false : can not be updated after inserted data
    @Column(name = "order_date",nullable = false, updatable = false)
    private LocalDateTime orderDate;

}
