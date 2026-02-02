package com.assignment1.service.implement;


import com.assignment1.dto.request.OrderRequestDTO;
import com.assignment1.dto.response.OrderDetailResponseDTO;
import com.assignment1.dto.response.OrderListResponseDTO;
import com.assignment1.entity.Order;

import com.assignment1.exception.EmailAlreadyExisted;
import com.assignment1.exception.EmailNotExistedException;
import com.assignment1.mapper.OrderMapper;
import com.assignment1.repository.OrderRepository;
import com.assignment1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.cfg.MapperBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository ;
    private final OrderMapper orderMapper ;
    private final MapperBuilder mapperBuilder;

    @Override
    public long generateID() {
        return orderRepository.count();
    }

    @Override
    public Order saveOrder(OrderRequestDTO dto) {
        if(orderRepository.existsOrderByEmail(dto.getEmail())){
           throw new EmailAlreadyExisted("email already existed!");
        }
        return orderRepository.save(orderMapper.toEntity(dto, generateID()));
    }

    @Override
    public List<OrderListResponseDTO> getALlOrder() {
        return orderRepository.findAll().stream()
                .map(order -> orderMapper.toOrderListResponse(order)).toList();

    }

    @Override
    public OrderDetailResponseDTO getOrderDetailByEmail(String email) {

        return orderRepository.findByEmail(email)
                .map(orderMapper::toOrderDetailResponse)
                .orElseThrow(() -> new EmailNotExistedException("email not existed"));

    }
}