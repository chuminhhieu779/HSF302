package com.assignment1.implement;


import com.assignment1.dto.creation.OrderCreationDTO;
import com.assignment1.entity.Order;
import com.assignment1.exception.EmailAlreadyExisted;
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
    public long generateID() {
        return orderRepository.count();
    }

    @Override
    public Order saveOrder(OrderCreationDTO dto) {
        if(orderRepository.existsOrderByEmail(dto.getEmail())){
           throw new EmailAlreadyExisted("email already existed !!");
        }
        return orderRepository.save(orderMapper.toEntity(dto, generateID()));
    }

}