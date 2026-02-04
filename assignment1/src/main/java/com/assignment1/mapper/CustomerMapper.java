package com.assignment1.mapper;

import com.assignment1.dto.request.CustomerRequestDTO;
import com.assignment1.entity.City;
import com.assignment1.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerRequestDTO dto, long countIDCustomer, long countIDCity){
         Customer customer1 = new Customer();
         String cusID =  customer1.createID("ORD00", countIDCustomer );
         City city1 = new City();
         String cityID = city1.createID("CT00", countIDCity);
         City city = City.builder()
                 .id(cityID)
                 .name(dto.getCity())
                 .build();
        return  Customer.builder()
                .id(cusID)
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .addressLine1(dto.getAddressLine1())
                .addressLine2(dto.getAddressLine2())
                .city(city)
                .build();
    }
}
