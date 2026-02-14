package com.assignment1.repository;

import com.assignment1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
//
//    boolean existsOrderByEmail(String email);
//     List<Order> findAll();
//    String findIdByEmail(String email);
//    Optional<Order> findByEmail(String email);

}
