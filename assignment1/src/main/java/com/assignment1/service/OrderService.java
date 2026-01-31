package com.assignment1.service;

import com.assignment1.dto.creation.OrderCreationDTO;
import com.assignment1.entity.Order;

public interface OrderService {
    Order saveOrder(OrderCreationDTO dto);
    long generateID();
}