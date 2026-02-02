package com.assignment1.repository;

import com.assignment1.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, String> {

    boolean existsOrderByEmail(String email);
     List<Order> findAll();

    List<Order> findByEmail(String email);
}
