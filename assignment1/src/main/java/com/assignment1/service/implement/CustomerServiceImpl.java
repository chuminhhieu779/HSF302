package com.assignment1.service.implement;

import com.assignment1.dto.request.CustomerRequestDTO;
import com.assignment1.entity.Customer;
import com.assignment1.exception.UserNotExistedException;
import com.assignment1.mapper.CustomerMapper;
import com.assignment1.repository.CityRepository;
import com.assignment1.repository.CustomerRepository;
import com.assignment1.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class  CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository ;
    private final CityRepository cityRepository ;
    private final CustomerMapper mapper ;

    @Override
    public void saveCustomer(CustomerRequestDTO dto) {
        Customer customer = mapper.toEntity(dto, customerRepository.count() , cityRepository.count());
        customerRepository.save(customer);
    }

    @Override
    public int findIdByEmail(String email) {
        return 0;
    }

    @Override
    public Customer checkUserExist(String email) {
        return customerRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotExistedException("you have to sign up before ordering product"));
    }
}
