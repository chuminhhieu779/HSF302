package com.assignment1.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderRequestDTO {

        @NotBlank(message = "validation.name.null")
        @Size(min = 2, max = 50)
        @Pattern(message = "validation.name.invalid_format", regexp = "^[\\p{L} ]+$")
        private String firstName;

        @NotBlank(message = "validation.name.null")
        @Size(min = 2, max = 50)
        @Pattern(message = "validation.name.invalid_format", regexp = "^[\\p{L} ]+$")
        private String lastName;

        @NotBlank(message = "validation.email.null")
        @Email(message = "validation.email.invalid_format")
        private String email;

        @NotBlank(message = "validation.phoneNumber.null")
        @Pattern(message = "validation.phoneNumber.invalid_format", regexp = "^[0-9 ]{7,20}$")
        private String phoneNumber;

        @NotBlank(message = "validation.address.null")
        private String addressLine1;

        @NotBlank(message = "validation.address.null")
        private String addressLine2;

        @NotBlank(message = "validation.city.null")
        @Pattern(message = "validation.city.invalid_format", regexp = "^[\\p{L} ]+$")
        private String city;

        private String region;

        @NotBlank(message = "validation.postalCode.null")
        @Size(min = 3, max = 10)
        @Pattern(message = "validation.postalCode.invalid_format", regexp = "^[A-Za-z0-9]+$")
        private String postalCode;

        @NotBlank(message = "validation.country.null")
        private String country;

}