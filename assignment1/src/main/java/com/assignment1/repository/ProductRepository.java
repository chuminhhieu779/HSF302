package com.assignment1.repository;

import com.assignment1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
