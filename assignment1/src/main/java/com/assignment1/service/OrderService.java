package com.assignment1.service;

import com.assignment1.dto.response.OrderDetailResponseDTO;
import com.assignment1.dto.response.OrderListResponseDTO;
import com.assignment1.entity.Customer;
import com.assignment1.entity.Order;
import com.assignment1.entity.OrderDetail;
import com.assignment1.entity.Product;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<OrderListResponseDTO> getALlOrder();
    void confirmOrderProduct(List<String> productID , String userEmail , Map<String, String > map );
}