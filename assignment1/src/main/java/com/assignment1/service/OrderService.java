package com.assignment1.service;

import com.assignment1.dto.request.OrderRequestDTO;
import com.assignment1.dto.response.OrderDetailResponseDTO;
import com.assignment1.dto.response.OrderListResponseDTO;
import com.assignment1.entity.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(OrderRequestDTO dto);
    long generateID();
    List<OrderListResponseDTO> getALlOrder();
    List<OrderDetailResponseDTO> getOrderDetailByEmail(String email);
}