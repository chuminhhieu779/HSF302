package com.assignment1.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CityRequestDTO {

    @NotNull(message = "name must be not null")
    private String name ;
    private String region ;
    @NotNull(message = "postalCode must be not null")
    @Size(min = 3, max = 10)
    @Pattern(message = "postalCode is invalid format", regexp = "^[A-Za-z0-9]+$")
    private String postalCode;
}
