package com.assignment1.repository;


import com.assignment1.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByEmail(String email);
    @Query("""
    SELECT DISTINCT c
    FROM Customer c
    JOIN FETCH c.city ci
    JOIN FETCH ci.country co
    JOIN FETCH c.orderList o
    JOIN FETCH o.orderDetailList od
    JOIN FETCH od.product p
""")
    List<Customer> customerHasOrderedList();

}
