package com.assignment1.service;


import com.assignment1.dto.request.CustomerRequestDTO;
import com.assignment1.entity.Customer;

public interface CustomerService {
     int findIdByEmail(String email);
     void saveCustomer(CustomerRequestDTO dto);
     Customer checkUserExist(String email);

}
