package com.assignment1.mapper;


import org.springframework.stereotype.Component;


@Component
public class OrderMapper {

//    public Order toEntity(OrderRequestDTO dto, long countID) {
//        Order order = new Order();
//        String id = order.createID("ORD00", countID);
//
//        Order order2 =  Order.builder()
//                .Id(id)
//                .firstName(dto.getFirstName())
//                .lastName(dto.getLastName())
//                .email(dto.getEmail())
//                .phoneNumber(dto.getPhoneNumber())
//                .addressLine1(dto.getAddressLine1())
//                .addressLine2(dto.getAddressLine2())
//                .city(dto.getCity())
//                .region(dto.getRegion())
//                .postalCode(dto.getPostalCode())
//                .country(dto.getCountry())
//                .build();
//        return order2;
//    }

//    public OrderListResponseDTO toOrderListResponse(Order order) {
//        OrderListResponseDTO orderListResponseDTO = new OrderListResponseDTO(
//                order.getId(),
//                order.getFirstName() + " "  + order.getLastName(),
//                order.getEmail(),
//                order.getAddressLine1() + " " + order.getAddressLine2(),
//                order.getCity()
//        );
//        return orderListResponseDTO ;
//    }

//    public OrderDetailResponseDTO toOrderDetailResponse(Order order){
//        return OrderDetailResponseDTO.builder()
//                .firstName(order.ge)
//                .lastName(order.getLastName())
//                .email(order.getEmail())
//                .phoneNumber(order.getPhoneNumber())
//                .addressLine1(order.getAddressLine1())
//                .addressLine2(order.getAddressLine2())
//                .city(order.getCity())
//                .region(order.getRegion())
//                .postalCode(order.getPostalCode())
//                .country(order.getCountry())
//                .orderDate(order.getOrderDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")))
//                .build();
//    }

}
