package com.assignment1.dto.response;

public record OrderResponseDTO (
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String addressLine1,
        String addressLine2,
        String city,
        String region,
        String postalCode,
        String country
){}