package com.assignment1.dto.creation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record OrderCreationDTO (
        @NotBlank
        @Size(min = 2 , max = 50)
        @Pattern(regexp = "^[A-Za-z]+$")
        String firstName,

        @NotBlank
        @Size(min = 2 , max = 50)
        @Pattern(regexp = "^[A-Za-z]+$")
        String lastName,

        @Email
        @NotBlank
        String email,

        @NotBlank
        @Pattern(regexp = "^\\+[0-9 ]{7,20}$")
        String phoneNumber,

        @NotBlank
        String addressLine1,
        @NotBlank
        String addressLine2,

        @NotBlank
        String city,
        String region,

        @NotBlank
        @Size(min = 3 , max = 10)
        @Pattern(regexp = "^[A-Za-z0-9]+$")
        String postalCode,

        @NotBlank
        String country
){}