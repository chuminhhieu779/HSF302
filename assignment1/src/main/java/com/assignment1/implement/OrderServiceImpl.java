package com.assignment1.implement;


import com.assignment1.dto.creation.OrderCreationDTO;
import com.assignment1.entity.Order;
import com.assignment1.mapper.OrderMapper;
import com.assignment1.repository.OrderRepository;
import com.assignment1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository ;
    private final OrderMapper orderMapper ;
    @Override
    public Order saveOrder(OrderCreationDTO dto) {
        return orderRepository.save(orderMapper.toEntiy(dto));
    }

}