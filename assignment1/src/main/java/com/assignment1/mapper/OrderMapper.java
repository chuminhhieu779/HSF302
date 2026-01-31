package com.assignment1.mapper;


import com.assignment1.dto.creation.OrderCreationDTO;
import com.assignment1.entity.Order;
import org.springframework.stereotype.Component;


@Component
public class OrderMapper {

    public Order toEntity(OrderCreationDTO dto, long countID) {
        Order order = new Order();
        String id = order.createID("ORD00", countID);

        Order order2 =  Order.builder()
                .Id(id)
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .addressLine1(dto.getAddressLine1())
                .addressLine2(dto.getAddressLine2())
                .city(dto.getCity())
                .region(dto.getRegion())
                .postalCode(dto.getPostalCode())
                .country(dto.getCountry())
                .build();
        return order2;
    }
}
