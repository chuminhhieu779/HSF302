package com.assignment1.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record ProductRequestDTO (
    String name,
    int quantity
){}
