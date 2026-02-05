package com.assignment1.service;


import com.assignment1.dto.request.CustomerRequestDTO;
import com.assignment1.dto.response.CustomerResponseDTO;
import com.assignment1.entity.Customer;

import java.util.List;

public interface CustomerService {
     int findIdByEmail(String email);
     void saveCustomer(CustomerRequestDTO dto);
     Customer checkUserExist(String email);
     List<CustomerResponseDTO> findAllcustomer();
}
