package com.assignment1.mapper;


import com.assignment1.dto.creation.OrderCreationDTO;
import com.assignment1.entity.Order;
import org.springframework.stereotype.Component;


@Component
public class OrderMapper {
    public Order toEntiy(OrderCreationDTO dto) {
        Order order = new Order();
        order.setFirstName(dto.firstName());
        order.setLastName(dto.lastName());
        order.setEmail(dto.email());
        order.setPhoneNumber(dto.phoneNumber());
        order.setAddressLine1(dto.addressLine1());
        order.setAddressLine2(dto.addressLine2());
        order.setCity(dto.city());
        order.setRegion(dto.region());
        order.setPostalCode(dto.postalCode());
        order.setCountry(dto.country());
        return order ;
    }
}
