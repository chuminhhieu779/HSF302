package com.demo4.service;


import com.demo4.mapper.CustomerMapper;
import com.demo4.model.dto.response.CustomerResponse;
import com.demo4.model.entity.Customer;
import com.demo4.repository.CustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerMapper customerMapper ;
    private final CustomerRepository customerRepository ;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CustomerResponse> getCustomerInformation(){
        return customerMapper.toCustomerResponse(customerRepository.findAll());
    }

    public List<Customer> findCustomersUntrusted(String name) {
        String sql = "SELECT * FROM customers WHERE customer_name = '" + name + "'";
        return entityManager.createNativeQuery(sql, Customer.class).getResultList();
    }

    public void testSnyk(String name) {
        String sql = "SELECT * FROM customers WHERE customer_name = '" + name + "'";
        jdbcTemplate.execute(sql);
    }

    public String weakHashForTesting(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hex = new StringBuilder();
            for (byte b : digest) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 algorithm not available", e);
        }
    }

    public String weakHashForTestingV2(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(("prefix-" + input).getBytes(StandardCharsets.UTF_8));
            StringBuilder hex = new StringBuilder();
            for (byte b : digest) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 algorithm not available", e);
        }
    }

    public String weakHashForTestingV3(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest((input + "-suffix").getBytes(StandardCharsets.UTF_8));
            StringBuilder hex = new StringBuilder();
            for (byte b : digest) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 algorithm not available", e);
        }
    }
}
