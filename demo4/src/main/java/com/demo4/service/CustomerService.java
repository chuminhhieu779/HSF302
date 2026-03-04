package com.demo4.service;


import com.demo4.mapper.CustomerMapper;
import com.demo4.model.dto.response.CustomerResponse;
import com.demo4.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public List<CustomerResponse> getCustomerInformation() {
        return customerMapper.toCustomerResponse(customerRepository.findAll());
    }
}
