package com.assignment1.dto.request;


import com.assignment1.entity.City;
import com.assignment1.entity.Order;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class CustomerRequestDTO {

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
    private String city ;

}
