package com.assignment1.service;

import java.util.List;
import java.util.Map;

public interface OrderService {
//    List<OrderListResponseDTO> getALlOrder();
    void confirmOrderProduct(List<String> productID , String userEmail , Map<String, String > map );
}