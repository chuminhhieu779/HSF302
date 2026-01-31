package com.assignment1.dto.creation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderCreationDTO {

        @NotBlank
        @Size(min = 2, max = 50)
        @Pattern(regexp = "^[\\p{L} ]+$")
        private String firstName;

        @NotBlank
        @Size(min = 2, max = 50)
        @Pattern(regexp = "^[\\p{L} ]+$")
        private String lastName;

        @NotBlank
        @Email
        private String email;

        @NotBlank
        @Pattern(regexp = "^[0-9 ]{7,20}$")
        private String phoneNumber;

        @NotBlank
        private String addressLine1;

        @NotBlank
        private String addressLine2;

        @NotBlank
        @Pattern(regexp = "^[\\p{L} ]+$")
        private String city;

        private String region;

        @NotBlank
        @Size(min = 3, max = 10)
        @Pattern(regexp = "^[A-Za-z0-9]+$")
        private String postalCode;

        @NotBlank
        private String country;
}