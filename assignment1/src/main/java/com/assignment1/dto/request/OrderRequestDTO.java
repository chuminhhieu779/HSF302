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
        @NotBlank(message = "name must be not null")
        @Size(min = 2, max = 50)
        @Pattern(message = "name is invalid format", regexp = "^[\\p{L} ]+$")
        private String firstName;

        @NotBlank(message = "name must be not null")
        @Size(min = 2, max = 50)
        @Pattern(message = "name is invalid format", regexp = "^[\\p{L} ]+$")
        private String lastName;

        @NotBlank(message = "email must be not null")
        @Email(message = "email is invalid format")
        private String email;

        @NotBlank(message = "phone number must be not null")
// Validates international phone number with country code
        @Pattern(message = "phone number is invalid format", regexp = "^\\+[0-9]{1,3}(\\s[0-9]{3}){2,3}$")
        private String phoneNumber;

        @NotBlank(message = "address must be not null")
        private String addressLine1;

        private String addressLine2;

        @NotBlank(message = "city must be not null")
        @Pattern(message = "city is invalid format", regexp = "^[\\p{L} ]+$")
        private String city;

        private String region;

        @NotBlank(message = "postalCode must be not null")
        @Size(min = 3, max = 10)
        @Pattern(message = "postalCode is invalid format", regexp = "^[A-Za-z0-9]+$")
        private String postalCode;

        @NotBlank(message = "you have to choose country")
        private String country;

}