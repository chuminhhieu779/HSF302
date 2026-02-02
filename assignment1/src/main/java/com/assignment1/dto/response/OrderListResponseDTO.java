package com.assignment1.dto.response;

public record OrderListResponseDTO(
     String orderId ,
     String fullName ,
     String email,
     String address ,
     String city
){}